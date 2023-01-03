package net.xdclass.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Data
@Configuration
@ConfigurationProperties(prefix = "pay.wechat")
public class WechatPayConfig {

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 公众号id 需要和商户号绑定
     */
    private String wxPayAppid;
    /**
     * 商户证书序列号,需要和证书对应
     */
    private String mchSerialNo;
    /**
     * API V3密钥
     */
    private String apiV3Key;
    /**
     * 商户私钥路径（微信服务端会根据证书序列号，找到证书获取公钥进行解密数据）
     */
    private String privateKeyPath;
    /**
     * 支付成功页面跳转
     */
    private String successReturnUrl;

    /**
     * 支付成功，回调通知
     */
    private String callbackUrl;



}
