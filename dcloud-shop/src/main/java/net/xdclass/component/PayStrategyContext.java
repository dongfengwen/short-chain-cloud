package net.xdclass.component;

import net.xdclass.vo.PayInfoVO;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class PayStrategyContext  {

    private PayStrategy payStrategy;

    public PayStrategyContext(PayStrategy payStrategy){
        this.payStrategy = payStrategy;
    }


    /**
     * 根据策略对象，执行不同的下单接口
     * @return
     */
    public String executeUnifiedOrder(PayInfoVO payInfoVO){

        return payStrategy.unifiedOrder(payInfoVO);
    }



    /**
     * 根据策略对象，执行不同的退款接口
     * @return
     */
    public String executeRefund(PayInfoVO payInfoVO){

        return payStrategy.refund(payInfoVO);
    }


    /**
     * 根据策略对象，执行不同的关闭接口
     * @return
     */
    public String executeCloseOrder(PayInfoVO payInfoVO){

        return payStrategy.closeOrder(payInfoVO);
    }


    /**
     * 根据策略对象，执行不同的查询订单状态接口
     * @return
     */
    public String executeQueryPayStatus(PayInfoVO payInfoVO){

        return payStrategy.queryPayStatus(payInfoVO);
    }


}
