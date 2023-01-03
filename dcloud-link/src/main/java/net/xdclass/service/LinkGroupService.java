package net.xdclass.service;

import net.xdclass.controller.request.LinkGroupAddRequest;
import net.xdclass.controller.request.LinkGroupUpdateRequest;
import net.xdclass.vo.LinkGroupVO;

import java.util.List;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public interface LinkGroupService {


    /**
     * 新增分组
     * @param addRequest
     * @return
     */
    int add(LinkGroupAddRequest addRequest);

    /**
     * 删除分组
     * @param groupId
     * @return
     */
    int del(Long groupId);

    /**
     * 详情
     * @param groupId
     * @return
     */
    LinkGroupVO detail(Long groupId);

    /**
     * 列出用户全部分组
     * @return
     */
    List<LinkGroupVO> listAllGroup();

    /**
     * 更新组名
     * @param request
     * @return
     */
    int updateById(LinkGroupUpdateRequest request);
}
