package net.xdclass.config;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class WechatPayApi {


    /**
     * 微信支付主机地址
     */
    public static final String HOST = "https://api.mch.weixin.qq.com";


    /**
     * Native下单
     */
    public static final String NATIVE_ORDER = HOST+ "/v3/pay/transactions/native";



    /**
     * Native订单状态查询, 根据商户订单号查询
     */
    public static final String NATIVE_QUERY = HOST+ "/v3/pay/transactions/out-trade-no/%s?mchid=%s";


    /**
     * 关闭订单接口
     */
    public static final String NATIVE_CLOSE_ORDER = HOST+ "/v3/pay/transactions/out-trade-no/%s/close";



    /**
     * 申请退款接口
     */
    public static final String NATIVE_REFUND_ORDER = HOST+ "/v3/refund/domestic/refunds";


    /**
     * 退款状态查询接口
     */
    public static final String NATIVE_REFUND_QUERY = HOST+ "/v3/refund/domestic/refunds/%s";

}
