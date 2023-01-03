package net.xdclass.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Configuration
@Slf4j
public class RabbitMQErrorConfig {


    /**
     * 异常交换机
     */
    private String shortLinkErrorExchange = "short_link.error.exchange";

    /**
     * 异常队列
     */
    private String shortLinkErrorQueue = "short_link.error.queue";

    /**
     * 异常routing.key
     */
    private String shortLinkErrorRoutingKey = "short_link.error.routing.key";


    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 创建异常交换机
     * @return
     */
    @Bean
    public TopicExchange errorTopicExchange(){

        return new TopicExchange(shortLinkErrorExchange,true,false);
    }

    /**
     * 创建异常队列
     * @return
     */

    @Bean
    public Queue errorQueue(){
        return new Queue(shortLinkErrorQueue,true);
    }


    /**
     * 建立绑定关系
     * @return
     */
    @Bean
    public Binding bindingErrorQueueAndExchange(){

        return BindingBuilder.bind(errorQueue()).to(errorTopicExchange()).with(shortLinkErrorRoutingKey);
    }


    /**
     * 配置  RepublishMessageRecoverer
     *
     * 消费消息重试一定次数后，用特定的routingKey转发到指定的交换机中，方便后续排查和告警
     *
     * @return
     */
    @Bean
    public MessageRecoverer messageRecoverer(){

        return new RepublishMessageRecoverer(rabbitTemplate,shortLinkErrorExchange,shortLinkErrorRoutingKey);
    }



}
