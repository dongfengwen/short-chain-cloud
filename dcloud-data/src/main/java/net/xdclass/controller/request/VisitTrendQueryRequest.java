package net.xdclass.controller.request;

import lombok.Data;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Data
public class VisitTrendQueryRequest {

    private String code;
    /**
     * 跨天、当天24小时、分钟级别
     */
    private String type;

    private String startTime;

    private String endTime;

}