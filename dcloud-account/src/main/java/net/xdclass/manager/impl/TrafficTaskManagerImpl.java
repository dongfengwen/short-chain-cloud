package net.xdclass.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import net.xdclass.manager.TrafficTaskManager;
import net.xdclass.mapper.TrafficTaskMapper;
import net.xdclass.model.TrafficTaskDO;
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
@Slf4j
public class TrafficTaskManagerImpl implements TrafficTaskManager {

    @Autowired
    private TrafficTaskMapper trafficTaskMapper;

    @Override
    public int add(TrafficTaskDO trafficTaskDO) {
        return trafficTaskMapper.insert(trafficTaskDO);
    }

    @Override
    public TrafficTaskDO findByIdAndAccountNo(Long id, Long accountNo) {
        TrafficTaskDO taskDO = trafficTaskMapper.selectOne(new QueryWrapper<TrafficTaskDO>()
                .eq("id", id).eq("account_no", accountNo));
        return taskDO;
    }

    @Override
    public int deleteByIdAndAccountNo(Long id, Long accountNo) {
        return trafficTaskMapper.delete(new QueryWrapper<TrafficTaskDO>()
                .eq("id", id).eq("account_no", accountNo));
    }
}
