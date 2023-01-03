package net.xdclass.service.impl;

import net.xdclass.controller.request.*;
import net.xdclass.enums.DateTimeFieldEnum;
import net.xdclass.enums.QueryDeviceEnum;
import net.xdclass.interceptor.LoginInterceptor;
import net.xdclass.mapper.VisitStatsMapper;
import net.xdclass.model.VisitStatsDO;
import net.xdclass.service.VisitStatsService;
import net.xdclass.vo.VisitStatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Service
public class VisitStatsServiceImpl implements VisitStatsService {

    @Autowired
    private VisitStatsMapper visitStatsMapper;


    @Override
    public Map<String, Object> pageVisitRecord(VisitRecordPageRequest request) {
        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();

        Map<String, Object> data = new HashMap<>(16);

        String code = request.getCode();
        int page = request.getPage();
        int size = request.getSize();

        int count = visitStatsMapper.countTotal(code, accountNo);
        int from = (page - 1) * size;

        List<VisitStatsDO> list = visitStatsMapper.pageVisitRecord(code, accountNo, from, size);

        List<VisitStatsVO> visitStatsVOS = list.stream().map(obj -> beanProcess(obj)).collect(Collectors.toList());

        data.put("total", count);
        data.put("current_page", page);

        /**计算总页数*/
        int totalPage = 0;
        if (count % size == 0) {
            totalPage = count / size;
        } else {
            totalPage = count / size + 1;
        }
        data.put("total_page", totalPage);

        data.put("data", visitStatsVOS);
        return data;

    }


    @Override
    public List<VisitStatsVO> queryRegionWithDay(RegionQueryRequest request) {
        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();
        List<VisitStatsDO> list = visitStatsMapper.queryRegionVisitStatsWithDay(request.getCode(), accountNo, request.getStartTime(), request.getEndTime());

        List<VisitStatsVO> visitStatsVOS = list.stream().map(obj -> beanProcess(obj)).collect(Collectors.toList());

        return visitStatsVOS;
    }

    @Override
    public List<VisitStatsVO> queryVisitTrend(VisitTrendQueryRequest request) {
        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();

        String code = request.getCode();

        String type = request.getType();

        String startTime = request.getStartTime();
        String endTime = request.getEndTime();
        List<VisitStatsDO> list = null;

        if (DateTimeFieldEnum.DAY.name().equalsIgnoreCase(type)) {

            list = visitStatsMapper.queryVisitTrendWithMultiDay(code, accountNo, startTime, endTime);

        } else if (DateTimeFieldEnum.HOUR.name().equalsIgnoreCase(type)) {
            list = visitStatsMapper.queryVisitTrendWithHour(code, accountNo, startTime);


        } else if (DateTimeFieldEnum.MINUTE.name().equalsIgnoreCase(type)) {
            list = visitStatsMapper.queryVisitTrendWithMinute(code, accountNo, startTime, endTime);

        }

        List<VisitStatsVO> visitStatsVOS = list.stream().map(obj -> beanProcess(obj)).collect(Collectors.toList());
        return visitStatsVOS;


    }

    @Override
    public List<VisitStatsVO> queryFrequentSource(FrequentSourceRequset request) {
        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();

        String code = request.getCode();


        String startTime = request.getStartTime();
        String endTime = request.getEndTime();

        List<VisitStatsDO> list = visitStatsMapper.queryFrequentSource(code, accountNo, startTime, endTime, 10);

        List<VisitStatsVO> visitStatsVOS = list.stream().map(obj -> beanProcess(obj)).collect(Collectors.toList());
        return visitStatsVOS;
    }


    @Override
    public Map<String, List<VisitStatsVO>> queryDeviceInfo(QueryDeviceRequest request) {


        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();

        String code = request.getCode();

        String startTime = request.getStartTime();
        String endTime = request.getEndTime();


        String os = QueryDeviceEnum.OS.name().toLowerCase();
        String browser = QueryDeviceEnum.BROWSER.name().toLowerCase();
        String device = QueryDeviceEnum.DEVICE.name().toLowerCase();

        List<VisitStatsDO> osList = visitStatsMapper.queryDeviceInfo(code, accountNo, startTime, endTime, os);

        List<VisitStatsDO> browserList = visitStatsMapper.queryDeviceInfo(code, accountNo, startTime, endTime, browser);

        List<VisitStatsDO> deviceList = visitStatsMapper.queryDeviceInfo(code, accountNo, startTime, endTime, device);

        List<VisitStatsVO> osVisitStatsVOS = osList.stream().map(obj -> beanProcess(obj)).collect(Collectors.toList());

        List<VisitStatsVO> browserVisitStatsVOS = browserList.stream().map(obj -> beanProcess(obj)).collect(Collectors.toList());

        List<VisitStatsVO> deviceVisitStatsVOS = deviceList.stream().map(obj -> beanProcess(obj)).collect(Collectors.toList());


        Map<String, List<VisitStatsVO>> map = new HashMap<>(3);
        map.put("os", osVisitStatsVOS);
        map.put("browser", browserVisitStatsVOS);
        map.put("device", deviceVisitStatsVOS);

        return map;
    }


    /**
     * map-struct
     *
     * @param visitStatsDO
     * @return
     */
    private VisitStatsVO beanProcess(VisitStatsDO visitStatsDO) {
        VisitStatsVO visitStatsVO = new VisitStatsVO();
        BeanUtils.copyProperties(visitStatsDO, visitStatsVO);
        return visitStatsVO;
    }

}
