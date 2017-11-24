package com.pay.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yepao.pojo.Orders;
import com.yepao.service.OrderService;
import com.yepao.utils.CommonUtil;
import com.yepao.utils.HttpResult;
import com.yepao.utils.HttpUtil;
import com.yepao.utils.RandomUtils;
import com.yepao.utils.TimeUtils;


@Controller
public class UnPayToPrePayController {

	@Autowired
	private OrderService orderService;
	
    private static Logger log = Logger.getLogger(UnPayToPrePayController.class);

    @ResponseBody
    @RequestMapping(value = "/prepay", produces = "text/html;charset=UTF-8")
    public String prePay(String desc,String count,String prePay,String talent,String hall,String combo,String celebration,String code, ModelMap model, HttpServletRequest request) {

        String content = null;
        Map map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();

        boolean result = true;
        String info = "";

        log.error("\n======================================================");
        log.error("code: " + code);

        //从微信端传过来的用户的code
        //调用下面的方法得到openid
        String openId = getOpenId(code);
        if(StringUtils.isBlank(openId)) {
            result = false;
            info = "获取到openId为空";
        } else {
        	//openID中间有斜杠，去掉
            openId = openId.replace("\"", "").trim();

            //获取客户终端IP
            String clientIP = CommonUtil.getClientIp(request);

            log.error("openId: " + openId + ", clientIP: " + clientIP);
            
            //返回一个定长的随机纯字母字符串
            String randomNonceStr = RandomUtils.generateMixString(32);
            
            //调用统一下单的接口生成预付款订单号
            Map<String, Object> map2 = unifiedOrder(desc,openId, clientIP, randomNonceStr);

            log.error("prepayId: " + map2.get("prepay_id"));

            if(StringUtils.isBlank(String.valueOf(map2.get("prepay_id")))) {
                result = false;
                info = "出错了，未获取到prepayId";
            } else {
                map.put("prepayId", map2.get("prepay_id"));
                map.put("nonceStr", randomNonceStr);
               
             
                	//如果成功的得到了预支付订单号就生成订单
                    Orders orders = new Orders();
                    orders.setId(Long.parseLong((String) map2.get("out_trade_no")));//商户订单号
                    orders.setWeipayid("");//微信交易号
                    orders.setPrepayId((String) map2.get("prepay_id"));
                    orders.setCustomerName("");//客户姓名
                    orders.setTel("");//客户联系方式
                    orders.setGender("");//性别
                    orders.setCustomerId("");//客户标识
                    orders.setHall("");//宴会厅
                    orders.setCombo("");//婚宴菜单
                    orders.setCelebration("");//宴会庆典
                    orders.setTalent("");//婚礼人才
                    BigDecimal b1 = new BigDecimal(prePay);
                    BigDecimal b2 = new BigDecimal(count);
                    BigDecimal b3 = b2.subtract(b1);
                    orders.setPrepay(b1);//定金
                    orders.setCount(b2);//总金额
                    orders.setObligation(b3);//待付尾款
                    orders.setStatus(ConstantStatus.UN_PAY);//状态
                    orders.setChecked(ConstantStatus.UN_CHECKED);//是否查看
                   Date date = new Date();
                    orders.setCreated(date);//订单创建时间
                    //计算订单失效时间
                    Date closeTime = TimeUtils.addDay(date, Constant.TIME_EXPIRE);
                    orders.setClosed(closeTime);//订单失效时间
                    orders.setPrepayed(null);//付定金时间
                    orders.setPayed(null);//付全款时间
                    //将该条记录插入表中，然后写一个定时任务超过时间未付款的关闭订单
                    //前端如果调用了支付成功了在发起请求更改订单状态为已经付了定金，取消支付的话就不用管了
                    orderService.addUnPayOrder(orders);
                    
                    //返回商户订单号和当前支付的订单类型
                    map.put("out_trade_no", map2.get("out_trade_no"));
                    map.put("unPayTransPay", "unPayToPrePay");
                
              
            }
        }

        try {
            map.put("result", result);
            map.put("info", info);
            content = mapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        

        return content;
    }


    private String getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + Constant.APP_ID +
                "&secret=" + Constant.APP_SECRET + "&js_code=" + code + "&grant_type=authorization_code";

        HttpUtil httpUtil = new HttpUtil();
        try {

        	//向微信发送请求
            HttpResult httpResult = httpUtil.doGet(url, null, null);

            if(httpResult.getStatusCode() == 200) {
            	//获取响应结果的响应体
                JsonParser jsonParser = new JsonParser();
                JsonObject obj = (JsonObject) jsonParser.parse(httpResult.getBody());

                log.error("getOpenId: " + obj.toString());

                //如果错误码不为空说明请求失败
                if(obj.get("errcode") != null) {
                    log.error("getOpenId returns errcode: " + obj.get("errcode"));
                    return "";
                } else {
                	//否则请求的到openID
                    return obj.get("openid").toString();
                }
                //return httpResult.getBody();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    

    /**
     * 调用统一下单接口
     * @param openId
     */
    private Map unifiedOrder(String desc,String openId, String clientIP, String randomNonceStr) {

        try {
        	//统一下单的路径
            String url = Constant.URL_UNIFIED_ORDER;

            //返回一个包含各种请求参数的对象
            PayInfo payInfo = createPayInfo(desc,openId, clientIP, randomNonceStr);
            
            //获取到经过MD5加密后的签名
            String md5 = getSign(payInfo);
            
            //将签名传入
            payInfo.setSign(md5);

            log.error("md5 value: " + md5);

            //将对象转换成xml格式
            String xml = CommonUtil.payInfoToXML(payInfo);
            //将特殊的字符替换掉
            xml = xml.replace("__", "_").replace("<![CDATA[1]]>", "1");
            //xml = xml.replace("__", "_").replace("<![CDATA[", "").replace("]]>", "");
            log.error(xml);

            //得到一个xml的缓冲区字符串
            StringBuffer buffer = HttpUtil.httpsRequest(url, "POST", xml);
            log.error("unifiedOrder request return body: \n" + buffer.toString());
            //解析xml字符串
            Map<String, String> result = CommonUtil.parseXml(buffer.toString());
            //获取返回状态码
            String return_code = result.get("return_code");
            //判断是否成功
            if(StringUtils.isNotBlank(return_code) && return_code.equals("SUCCESS")) {
            	//得到返回信息
                String return_msg = result.get("return_msg");
                
                if(StringUtils.isNotBlank(return_msg) && !return_msg.equals("OK")) {
                    //log.error("统一下单错误！");
                    return null;
                }

                //成功返回预支付交易单
                String prepay_Id = result.get("prepay_id");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("prepay_id", prepay_Id);
                map.put("out_trade_no", payInfo.getOut_trade_no());
                return map;

            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //得到一个付款详细信息对象
    private PayInfo createPayInfo(String desc,String openId, String clientIP, String randomNonceStr) {

        Date date = new Date();
        String timeStart = TimeUtils.getFormatTime(date, Constant.TIME_FORMAT);
        String timeExpire = TimeUtils.getFormatTime(TimeUtils.addDay(date, Constant.TIME_EXPIRE), Constant.TIME_FORMAT);

        //生成商户订单号
        String randomOrderId = CommonUtil.getRandomOrderId();

        PayInfo payInfo = new PayInfo();
        payInfo.setAppid(Constant.APP_ID);//小程序IP
        payInfo.setMch_id(Constant.MCH_ID);//商户号
        payInfo.setDevice_info("WEB");//设备号，固定值
        payInfo.setNonce_str(randomNonceStr);//随机字符串
        payInfo.setSign_type("MD5");  //默认即为MD5加密
        payInfo.setBody("JSAPI支付测试");//商品描述
        payInfo.setAttach("支付测试4luluteam");//附加信息
        payInfo.setOut_trade_no(randomOrderId);//商户订单号，随机生成
        payInfo.setTotal_fee(1);//总金额
        payInfo.setSpbill_create_ip(clientIP);//终端IP
        payInfo.setTime_start(timeStart);//交易起始时间
        payInfo.setTime_expire(timeExpire);//交易结束时间
        payInfo.setNotify_url(Constant.URL_NOTIFY);//通知地址
        payInfo.setTrade_type("JSAPI");//交易类型，固定值
        payInfo.setLimit_pay("no_credit");//支付方式
        payInfo.setOpenid(openId);//用户标识

        return payInfo;
    }

    private String getSign(PayInfo payInfo) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("appid=" + payInfo.getAppid())
                .append("&attach=" + payInfo.getAttach())
                .append("&body=" + payInfo.getBody())
                .append("&device_info=" + payInfo.getDevice_info())
                .append("&limit_pay=" + payInfo.getLimit_pay())
                .append("&mch_id=" + payInfo.getMch_id())
                .append("&nonce_str=" + payInfo.getNonce_str())
                .append("&notify_url=" + payInfo.getNotify_url())
                .append("&openid=" + payInfo.getOpenid())
                .append("&out_trade_no=" + payInfo.getOut_trade_no())
                .append("&sign_type=" + payInfo.getSign_type())
                .append("&spbill_create_ip=" + payInfo.getSpbill_create_ip())
                .append("&time_expire=" + payInfo.getTime_expire())
                .append("&time_start=" + payInfo.getTime_start())
                .append("&total_fee=" + payInfo.getTotal_fee())
                .append("&trade_type=" + payInfo.getTrade_type())
                .append("&key=" + Constant.APP_KEY);

        log.error("排序后的拼接参数：" + sb.toString());

        return CommonUtil.getMD5(sb.toString().trim()).toUpperCase();
    }



}


