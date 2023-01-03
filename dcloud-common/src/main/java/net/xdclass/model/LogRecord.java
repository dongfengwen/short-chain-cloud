package net.xdclass.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class LogRecord {

    /**
     * 客户端ip
     */
    private String ip;

    /**
     * 产生时间戳
     */
    private Long ts;


    /**
     * 日志事件类型
     */
    private String event;


    /**
     * udid，是设备的唯一标识，全称uniqueDeviceIdentifier
     */
    private String udid;


    /**
     * 业务id
     */
    private String bizId;


    /**
     * 日志内容
     */
    private Object data;

}
