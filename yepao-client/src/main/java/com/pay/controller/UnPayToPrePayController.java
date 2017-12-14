package com.pay.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.zxing.WriterException;
import com.other.pojo.CelebrationAsistant;
import com.other.pojo.OrderAsistant;
import com.websocket.controller.PointWebSocketHandler;
import com.yepao.pojo.BanquetHall;
import com.yepao.pojo.Celebration;
import com.yepao.pojo.Combo;
import com.yepao.pojo.Orders;
import com.yepao.pojo.WeddingTalent;
import com.yepao.service.AppointmentPayService;
import com.yepao.service.CelebrationService;
import com.yepao.service.ComboService;
import com.yepao.service.HallService;
import com.yepao.service.OrderService;
import com.yepao.service.TalentService;
import com.yepao.utils.CommonUtil;
import com.yepao.utils.FastDFSClient;
import com.yepao.utils.HttpResult;
import com.yepao.utils.HttpUtil;
import com.yepao.utils.JsonUtils;
import com.yepao.utils.RandomUtils;
import com.yepao.utils.TimeUtils;
import com.yepao.utils.TwoBarCodesUtil;

import sun.font.StrikeCache;


@Controller
public class UnPayToPrePayController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Autowired
	private OrderService orderService;
	@Autowired
	private HallService hallService;
	@Autowired
	private ComboService comboService;
	@Autowired
	private TalentService talentService;
	@Autowired
	private CelebrationService celebrationService;
	@Autowired
	private AppointmentPayService appointmentPayService;
	
    private static Logger log = Logger.getLogger(UnPayToPrePayController.class);

    @ResponseBody
    @RequestMapping("/prepay")
    public String prePay(Orders orders, BigDecimal celePrice,String reservedDates,String comboStyle,Boolean isStage,String count,String prePay,String talent,Long hall,Integer hallTable,Long combo,Long celebration, ModelMap model, HttpServletRequest request) {
/*
        String content = null;
        Map map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();

        boolean result = true;
        String info = "";

        log.error("\n======================================================");
        log.error("code: " + code);*/

        //从微信端传过来的用户的code
        //调用下面的方法得到openid
        //String openId = getOpenId(code);
        /*if(StringUtils.isBlank(openId)) {
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
            Map<String, Object> map2 = unifiedOrder(orders.getDescription(),openId, clientIP, randomNonceStr);

            log.error("prepayId: " + map2.get("prepay_id"));

            if(StringUtils.isBlank(String.valueOf(map2.get("prepay_id")))) {
                result = false;
                info = "出错了，未获取到prepayId";
            } else {
                map.put("prepayId", map2.get("prepay_id"));
                map.put("nonceStr", randomNonceStr);
               */
             
                	//如果成功的得到了预支付订单号就生成订单
                   // orders.setId(Long.parseLong((String) map2.get("out_trade_no")));//商户订单号
    				Long out_trade_no = CommonUtil.getRandomOrderId();
                    orders.setId(out_trade_no);//商户订单号
                    
                    StringBuilder str=new StringBuilder();//定义变长字符串
            		Random random=new Random();
            		//随机生成数字，并添加到字符串
            		for(int i=0;i<8;i++){
            		    str.append(random.nextInt(10));
            		}
            		//将字符串转换为数字并输出
            		String num=str.toString();
            		String url =null;
            		try {
						String returnPath = TwoBarCodesUtil.encode(num);
						// String realPath = request.getSession().getServletContext().getRealPath(returnPath);
						 File file = new File(returnPath);
						 
						 byte[] buffer = null;  
					        try {    
					            FileInputStream fis = new FileInputStream(file);  
					            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
					            byte[] b = new byte[1000];  
					            int n;  
					            while ((n = fis.read(b)) != -1) {  
					                bos.write(b, 0, n);  
					            }  
					            fis.close();  
					            bos.close();  
					            buffer = bos.toByteArray(); 
					            String extName = file.getName().substring(file.getName().lastIndexOf(".") + 1);
					            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
								//3、执行上传处理并返回一个路径
								String path = fastDFSClient.uploadFile(buffer, extName);
								//4、拼接返回的url和ip地址，拼装成完整的url
								 url = IMAGE_SERVER_URL + path;
					        } catch (Exception e) {  
					            e.printStackTrace();  
					        } 
					} catch (WriterException | IOException e1) {
						
						e1.printStackTrace();
					}
                    
            		
            		orders.setTwoBarCode(url);
                    orders.setVaidateCode(num);
                    orders.setPrepayId("112233");
                   // orders.setCustomerId(openId);
                    
                    String hallName = null;
                    if(hall!=null && hallTable!=null){
                    	  List<OrderAsistant> hallList1 = new ArrayList<OrderAsistant>();
                          List<BanquetHall> hallList2 = new ArrayList<BanquetHall>();
                          BanquetHall banquetHall = hallService.getBanquetHall(hall);
                          hallName=banquetHall.getName();
                          banquetHall.setImg(banquetHall.getImg().split(",")[0]);
                          OrderAsistant orderAsistant1 = new OrderAsistant();
                          orderAsistant1.setNum(hallTable);
                          hallList2.add(banquetHall);
                          orderAsistant1.setItemName(hallList2);
                          hallList1.add(orderAsistant1);
                          String hallJson = JsonUtils.objectToJson(hallList1);
                          orders.setHall(hallJson);
                    }
                  
                   if(combo!=null && hallTable!=null){
                	   List<OrderAsistant> comboList1 = new ArrayList<OrderAsistant>();
                	   List<Combo> comboList2 = new ArrayList<Combo>();
                       Combo combo2 = comboService.getCombo(combo);
                       comboList2.add(combo2);
                       OrderAsistant orderAsistant2 = new OrderAsistant();
                       orderAsistant2.setNum(hallTable);
                       orderAsistant2.setItemName(comboList2);
                       comboList1.add(orderAsistant2);
                       String comboJson = JsonUtils.objectToJson(comboList1);
                       orders.setCombo(comboJson);
                   }
                   
                    if(talent!=null && StringUtils.isNotBlank(talent)){
                    	  List<WeddingTalent> talentList = new ArrayList<WeddingTalent>();
                          String[] talentIds = talent.split(",");
                          for (String string : talentIds) {
      						Long talentId = Long.parseLong(string);
      						WeddingTalent weddingTalent = talentService.getWeddingTalent(talentId);
      						weddingTalent.setChosenCount(weddingTalent.getChosenCount()+1);
      						weddingTalent.setIntroduction(null);
      						talentList.add(weddingTalent);
      					}
                          String talentJson = JsonUtils.objectToJson(talentList);
                          orders.setTalent(talentJson);
                    }
                  
                    if(celebration!=null && (comboStyle!=null && StringUtils.isNotBlank(comboStyle))){
                    	List<Celebration> celebrationList = new ArrayList<Celebration>();
                    	List<CelebrationAsistant> celebrationAsistantList = new ArrayList<CelebrationAsistant>();
                        Celebration celebration2 = celebrationService.getCelebration(celebration);
                        celebration2.setWeddingplace(null);
                        celebration2.setCeremony(null);
                        celebration2.setDesklight(null);
                        celebration2.setStyle(null);
                        celebration2.setTheme(null);
                        celebration2.setStandby(null);
                        celebrationList.add(celebration2);
                        CelebrationAsistant celebrationAsistant = new CelebrationAsistant();
                        celebrationAsistant.setComboName(comboStyle);
                        celebrationAsistant.setStage(isStage);
                    
                     //   BigDecimal b4 = new BigDecimal(celePirce);
                       BigDecimal preprice = celebration2.getPreprice();
                       BigDecimal price = celebration2.getPrice();
                       if(celePrice.compareTo(preprice)==0){
                    	   celebrationAsistant.setLuxury(false);
                       }else if(celePrice.compareTo(price)==0){
                    	   celebrationAsistant.setLuxury(true);
                       }
                        
                        
                       
                        celebrationAsistant.setItemName(celebrationList);
                        celebrationAsistantList.add(celebrationAsistant);
                        String celebrationJson = JsonUtils.objectToJson(celebrationAsistantList);
                        orders.setCelebration(celebrationJson);//宴会庆典
                    }
                    
                    if(prePay!=null && prePay!=null){
                    	BigDecimal b1 = new BigDecimal(prePay);
                        BigDecimal b2 = new BigDecimal(count);
                    	 /* BigDecimal b1 = new BigDecimal(10);
                        BigDecimal b2 = new BigDecimal(20);*/
                        BigDecimal b3 = b2.subtract(b1);
                        orders.setPrepay(b1);//定金
                        orders.setCount(b2);//总金额
                        orders.setObligation(b3);//待付尾款
                    }
                    
                  
                    SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
						Date parse = sFormat.parse(reservedDates);
						orders.setReservedDate(parse);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
                    
                    orders.setStatus(ConstantStatus.PRE_PAY);//状态
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
                    
                    String content = null;
                    Map map = new HashMap();
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                    	map.put("out_trade_no", out_trade_no);
                    	map.put("validateCode", str);
                    	
						content = mapper.writeValueAsString(map);
					} catch (Exception e) {
						e.printStackTrace();
					}
                    //返回商户订单号和当前支付的订单类型
                    /*map.put("out_trade_no", map2.get("out_trade_no"));
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
        
        

        return content;*/
           Long hotelId = orders.getHotelId(); 
          appointmentPayService.addAppointmentPay(out_trade_no,hotelId, hall, hallName, orders.getCustomerName(), orders.getTel(), reservedDates);
         new PointWebSocketHandler().sendMessageToUser(orders.getHotelId(), new TextMessage(""));
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
        Long randomOrderId = CommonUtil.getRandomOrderId();

        PayInfo payInfo = new PayInfo();
        payInfo.setAppid(Constant.APP_ID);//小程序IP
        payInfo.setMch_id(Constant.MCH_ID);//商户号
        payInfo.setDevice_info("WEB");//设备号，固定值
        payInfo.setNonce_str(randomNonceStr);//随机字符串
        payInfo.setSign_type("MD5");  //默认即为MD5加密
        payInfo.setBody("JSAPI支付测试");//商品描述
        payInfo.setAttach("支付测试4luluteam");//附加信息
        payInfo.setOut_trade_no(randomOrderId.toString());//商户订单号，随机生成
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


