package net.xdclass.service;

import net.xdclass.controller.request.ConfirmOrderRequest;
import net.xdclass.controller.request.ProductOrderPageRequest;
import net.xdclass.enums.ProductOrderPayTypeEnum;
import net.xdclass.model.EventMessage;
import net.xdclass.util.JsonData;

import java.util.Map;

public interface ProductOrderService {

    Map<String,Object> page(ProductOrderPageRequest orderPageRequest);

    String queryProductOrderState(String outTradeNo);

    JsonData confirmOrder(ConfirmOrderRequest orderRequest);

    boolean closeProductOrder(EventMessage eventMessage);

    /**
     * 处理微信回调通知
     * @param wechatPay
     * @param paramsMap
     */
    JsonData processOrderCallbackMsg(ProductOrderPayTypeEnum wechatPay, Map<String, String> paramsMap);

    /**
     * 处理 队列里面的订单相关消息
     * @param message
     */
    void handleProductOrderMessage(EventMessage message);
}
