package net.xdclass.component;

import lombok.extern.slf4j.Slf4j;
import net.xdclass.enums.ProductOrderPayTypeEnum;
import net.xdclass.vo.PayInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Component
@Slf4j
public class PayFactory {

    @Autowired
    private AliPayStrategy aliPayStrategy;

    @Autowired
    private WechatPayStrategy wechatPayStrategy;

    /**
     * 创建支付，简单工厂模式
     * @param payInfoVO
     * @return
     */
    public String pay(PayInfoVO payInfoVO){

        String payType = payInfoVO.getPayType();

        if (ProductOrderPayTypeEnum.ALI_PAY.name().equals(payType)) {
            //支付宝支付
            PayStrategyContext payStrategyContext = new PayStrategyContext(aliPayStrategy);
            return payStrategyContext.executeUnifiedOrder(payInfoVO);

        } else if(ProductOrderPayTypeEnum.WECHAT_PAY.name().equals(payType)){

            //微信支付
            PayStrategyContext payStrategyContext = new PayStrategyContext(wechatPayStrategy);
            return payStrategyContext.executeUnifiedOrder(payInfoVO);
        }
        return "";
    }


    /**
     * 关闭订单
     * @param payInfoVO
     * @return
     */
    public String closeOrder(PayInfoVO payInfoVO){

        String payType = payInfoVO.getPayType();

        if (ProductOrderPayTypeEnum.ALI_PAY.name().equals(payType)) {
            //支付宝支付
            PayStrategyContext payStrategyContext = new PayStrategyContext(aliPayStrategy);
            return payStrategyContext.executeCloseOrder(payInfoVO);

        } else if(ProductOrderPayTypeEnum.WECHAT_PAY.name().equals(payType)){

            //微信支付
            PayStrategyContext payStrategyContext = new PayStrategyContext(wechatPayStrategy);
            return payStrategyContext.executeCloseOrder(payInfoVO);
        }
        return "";
    }


    /**
     * 查询支付状态
     * @param payInfoVO
     * @return
     */
    public String queryPayStatus(PayInfoVO payInfoVO){

        String payType = payInfoVO.getPayType();

        if (ProductOrderPayTypeEnum.ALI_PAY.name().equals(payType)) {
            //支付宝支付
            PayStrategyContext payStrategyContext = new PayStrategyContext(aliPayStrategy);
            return payStrategyContext.executeQueryPayStatus(payInfoVO);

        } else if(ProductOrderPayTypeEnum.WECHAT_PAY.name().equals(payType)){

            //微信支付
            PayStrategyContext payStrategyContext = new PayStrategyContext(wechatPayStrategy);
            return payStrategyContext.executeQueryPayStatus(payInfoVO);
        }
        return "";
    }


    /**
     * 退款接口
     * @param payInfoVO
     * @return
     */
    public String refund(PayInfoVO payInfoVO){

        String payType = payInfoVO.getPayType();

        if (ProductOrderPayTypeEnum.ALI_PAY.name().equals(payType)) {
            //支付宝支付
            PayStrategyContext payStrategyContext = new PayStrategyContext(aliPayStrategy);
            return payStrategyContext.executeRefund(payInfoVO);

        } else if(ProductOrderPayTypeEnum.WECHAT_PAY.name().equals(payType)){
            //微信支付
            PayStrategyContext payStrategyContext = new PayStrategyContext(wechatPayStrategy);
            return payStrategyContext.executeRefund(payInfoVO);
        }

        return "";
    }




}
