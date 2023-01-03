package net.xdclass.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventMessage implements Serializable {

    /**
     * 消息队列的消息id
     */
    private String messageId;


    /**
     * 事件类型
     */
    private String eventMessageType;


    /**
     * 业务id
     */
    private String bizId;


    /**
     * 账号
     */
    private Long accountNo;


    /**
     * 消息体
     */
    private String content;

    /**
     * 备注
     */
    private String remark;

}
