package net.xdclass.manager;

import net.xdclass.model.TrafficTaskDO;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public interface TrafficTaskManager {

    int add(TrafficTaskDO trafficTaskDO);

    TrafficTaskDO findByIdAndAccountNo(Long id,Long accountNo);

    int deleteByIdAndAccountNo(Long id,Long accountNo);

}
