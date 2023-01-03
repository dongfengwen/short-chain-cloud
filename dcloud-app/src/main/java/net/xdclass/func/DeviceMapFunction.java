package net.xdclass.func;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.xdclass.model.DeviceInfoDO;
import net.xdclass.model.ShortLinkWideDO;
import net.xdclass.util.DeviceUtil;
import org.apache.flink.api.common.functions.MapFunction;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class DeviceMapFunction implements MapFunction<String, ShortLinkWideDO> {

    @Override
    public ShortLinkWideDO map(String value) throws Exception {

        //还原json
        JSONObject jsonObject = JSON.parseObject(value);

        String userAgent = jsonObject.getJSONObject("data").getString("user-agent");

        DeviceInfoDO deviceInfoDO = DeviceUtil.getDeviceInfo(userAgent);

        String udid = jsonObject.getString("udid");
        deviceInfoDO.setUdid(udid);

        //配置短链基本信息宽表
        ShortLinkWideDO shortLinkWideDO = ShortLinkWideDO.builder()
                //短链访问基本信息
                .visitTime(jsonObject.getLong("ts"))
                .accountNo(jsonObject.getJSONObject("data").getLong("accountNo"))
                .code(jsonObject.getString("bizId"))
                .referer(jsonObject.getString("referer"))
                .isNew(jsonObject.getInteger("is_new"))
                .ip(jsonObject.getString("ip"))

                //设备信息补齐
                .browserName(deviceInfoDO.getBrowserName())
                .os(deviceInfoDO.getOs())
                .osVersion(deviceInfoDO.getOsVersion())
                .deviceType(deviceInfoDO.getDeviceType())
                .deviceManufacturer(deviceInfoDO.getDeviceManufacturer())
                .udid(deviceInfoDO.getUdid())

                .build();

        return shortLinkWideDO;
    }
}
