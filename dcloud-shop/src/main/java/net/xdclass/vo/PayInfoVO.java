package net.xdclass.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayInfoVO {

    private String outTradeNo;

    /**
     * 订单总金额 单位是分
     */
    private BigDecimal payFee;

    /**
     *支付类型，微信、支付宝
     */
    private String payType;


    /**
     * 端类型，App/h5/pc
     */
    private String clientType;


    /**
     * 标题
     */
    private String title;

    /**
     * 详情
     */
    private String description;

    /**
     * 订单支付超时，毫秒
     */
    private Long orderPayTimeoutMills;


    /**
     * 用户标识
     */
    private Long accountNo;
}
