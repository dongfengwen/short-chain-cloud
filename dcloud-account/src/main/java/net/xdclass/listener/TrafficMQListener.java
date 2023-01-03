package net.xdclass.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import net.xdclass.enums.BizCodeEnum;
import net.xdclass.exception.BizException;
import net.xdclass.model.EventMessage;
import net.xdclass.service.TrafficService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
@RabbitListener(queuesToDeclare = {
        @Queue("order.traffic.queue"),
        @Queue("traffic.free_init.queue"),
        @Queue("traffic.release.queue")
})
@Slf4j
public class TrafficMQListener {

    @Autowired
    private TrafficService trafficService;


    @RabbitHandler
    public void trafficHandler(EventMessage eventMessage, Message message, Channel channel){

        log.info("监听到消息trafficHandler:{}",eventMessage);

        try{

            trafficService.handleTrafficMessage(eventMessage);

        }catch (Exception e){
            log.error("消费者失败:{}",eventMessage);
            throw new BizException(BizCodeEnum.MQ_CONSUME_EXCEPTION);
        }

        log.info("消费成功:{}",eventMessage);

    }

}
