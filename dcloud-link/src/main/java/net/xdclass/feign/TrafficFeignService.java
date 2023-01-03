package net.xdclass.feign;

import net.xdclass.controller.request.UseTrafficRequest;
import net.xdclass.util.JsonData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dcloud-account-service")
public interface TrafficFeignService {

    /**
     * 使用流量包
     * @param request
     * @return
     */
    @PostMapping(value = "/api/traffic/v1/reduce",headers = {"rpc-token=${rpc.token}"})
    JsonData useTraffic(@RequestBody UseTrafficRequest request);

}
