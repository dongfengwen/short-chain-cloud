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
public class DeviceInfoDO {

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 系统
     */
    private String os;

    /**
     * 系统版本
     */
    private String osVersion;


    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 厂商
     */
    private String deviceManufacturer;


    /**
     * 终端用户唯一标识
     */
    private String udid;
}
