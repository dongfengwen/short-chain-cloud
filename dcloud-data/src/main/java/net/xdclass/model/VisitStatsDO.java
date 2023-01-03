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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisitStatsDO {

    /**
     * 窗口开始时间  Clickhouse里面会用到
     */
    String startTime;

    /**
     * 窗口结束时间
     */
    String endTime;

/**
 * ================================================
 */


    /**
     * 短链压缩码
     */
    private String code;

    /**
     * 租户id
     */
    private Long accountNo;


    /**
     * 访问时间
     */
    private Long visitTime;

    /**
     * 站点来源，只记录域名
     */
    private String referer;

    /**
     * 1是新访客，0是老访客
     */
    private Integer isNew;

    /**
     * 唯一标识
     */
    private String udid;

    //==============RegionInfoDO==================

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 运营商
     */
    private String isp;

    /**
     * 访问ip
     */
    private String ip;

//==============DeviceInfoDO==================

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 操作系统
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
     * 设备厂商
     */
    private String deviceManufacturer;

//==============度量==================

    private Long uv=0L;

    private Long pv=0L;



    private Long ipCount=0L;

    private Long pvCount=0L;

    private Long uvCount=0L;

    private Long newUVCount=0L;

    /**
     * 时间的字符串映射，天、小时*/

    private String dateTimeStr;
}