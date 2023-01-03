package net.xdclass.service;

import net.xdclass.util.JsonData;

import javax.servlet.http.HttpServletRequest;

public interface LogService {

    /**
     * 记录日志
     * @param request
     * @param shortLinkCode
     * @param accountNo
     * @return
     */
    void recordShortLinkLog(HttpServletRequest request,String shortLinkCode,Long accountNo);

}
