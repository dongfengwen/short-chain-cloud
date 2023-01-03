package net.xdclass.service;

import net.xdclass.controller.request.*;
import net.xdclass.vo.VisitStatsVO;

import java.util.List;
import java.util.Map;

public interface VisitStatsService {

    Map<String,Object> pageVisitRecord(VisitRecordPageRequest request);

    List<VisitStatsVO> queryRegionWithDay(RegionQueryRequest request);

    List<VisitStatsVO> queryVisitTrend(VisitTrendQueryRequest request);

    List<VisitStatsVO> queryFrequentSource(FrequentSourceRequset request);

    Map<String,List<VisitStatsVO>> queryDeviceInfo(QueryDeviceRequest request);
}
