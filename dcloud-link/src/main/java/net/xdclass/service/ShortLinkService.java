package net.xdclass.service;

import net.xdclass.controller.request.ShortLinkAddRequest;
import net.xdclass.controller.request.ShortLinkDelRequest;
import net.xdclass.controller.request.ShortLinkPageRequest;
import net.xdclass.controller.request.ShortLinkUpdateRequest;
import net.xdclass.model.EventMessage;
import net.xdclass.util.JsonData;
import net.xdclass.vo.ShortLinkVO;

import java.util.Map;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public interface ShortLinkService {

    /**
     * 解析短链
     *
     * @param shortLinkCode
     * @return
     */
    ShortLinkVO parseShortLinkCode(String shortLinkCode);

    /**
     * 创建短链
     *
     * @param request
     * @return
     */
    JsonData createShortLink(ShortLinkAddRequest request);


    /**
     * 分页查找短链
     *
     * @param request
     * @return
     */
    Map<String, Object> pageByGroupId(ShortLinkPageRequest request);

    /**
     * 删除短链
     *
     * @param request
     * @return
     */
    JsonData del(ShortLinkDelRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    JsonData update(ShortLinkUpdateRequest request);

    /**
     * 处理新增短链消息
     *
     * @param eventMessage
     * @return
     */
    boolean handleAddShortLink(EventMessage eventMessage);


    /**
     * 更新短链
     *
     * @param eventMessage
     * @return
     */
    boolean handleUpdateShortLink(EventMessage eventMessage);


    /**
     * 删除短链
     * @param eventMessage
     * @return
     */
    boolean handleDelShortLink(EventMessage eventMessage);

}