package net.xdclass.service;

import net.xdclass.controller.request.TrafficPageRequest;
import net.xdclass.controller.request.UseTrafficRequest;
import net.xdclass.model.EventMessage;
import net.xdclass.util.JsonData;
import net.xdclass.vo.TrafficVO;

import java.util.Map;

public interface TrafficService {



    void handleTrafficMessage(EventMessage eventMessage);

    Map<String,Object> pageAvailable(TrafficPageRequest request);

    TrafficVO detail(long trafficId);

    /**
     * 删除过期流量包
     * @return
     */
    boolean deleteExpireTraffic();

    /**
     * 扣减流量包
     * @param useTrafficRequest
     * @return
     */
    JsonData reduce(UseTrafficRequest useTrafficRequest);
}
