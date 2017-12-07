package com.pay.controller;

/**
 * Created by Hyman on 2017/2/27.
 */
public class Constant {

    public static final String DOMAIN = "https://i-test.com.cn";

    public static final String APP_ID = "wx418404c93e2872a0";//小程序的ID

    public static final String APP_SECRET = "680311cf183f757dd1be78e4d3f9efdb";//邮箱中发来的，AppSecret是APPID对应的接口密码，用于获取接口调用凭证时使用。

    public static final String APP_KEY = "填写自己的";//邮箱中发过来的

    public static final String MCH_ID = "填写自己的";  //微信支付商户号

    public static final String URL_UNIFIED_ORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";//调用路径

    public static final String URL_NOTIFY = Constant.DOMAIN + "/wxpay/views/payInfo.jsp";

    public static final String TIME_FORMAT = "yyyyMMddHHmmss";//时间格式，交易起始或者结束的时间

    public static final int TIME_EXPIRE = 2;  //单位是day

}
