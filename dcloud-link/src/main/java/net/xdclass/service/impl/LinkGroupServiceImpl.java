package net.xdclass.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.xdclass.controller.request.LinkGroupAddRequest;
import net.xdclass.controller.request.LinkGroupUpdateRequest;
import net.xdclass.interceptor.LoginInterceptor;
import net.xdclass.manager.LinkGroupManager;
import net.xdclass.model.LinkGroupDO;
import net.xdclass.service.LinkGroupService;
import net.xdclass.vo.LinkGroupVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
@Slf4j
public class LinkGroupServiceImpl implements LinkGroupService {

    @Autowired
    private LinkGroupManager linkGroupManager;

    @Override
    public int add(LinkGroupAddRequest addRequest) {

        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();


        LinkGroupDO linkGroupDO = new LinkGroupDO();
        linkGroupDO.setTitle(addRequest.getTitle());
        linkGroupDO.setAccountNo(accountNo);

        int rows = linkGroupManager.add(linkGroupDO);

        return rows;
    }


    @Override
    public int del(Long groupId) {

        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();

        return linkGroupManager.del(groupId, accountNo);

    }

    @Override
    public LinkGroupVO detail(Long groupId) {

        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();

        LinkGroupDO linkGroupDO = linkGroupManager.detail(groupId, accountNo);

        LinkGroupVO linkGroupVO = new LinkGroupVO();

        // mapStruct
        BeanUtils.copyProperties(linkGroupDO, linkGroupVO);

        return linkGroupVO;
    }

    @Override
    public List<LinkGroupVO> listAllGroup() {

        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();

        List<LinkGroupDO> linkGroupDOList = linkGroupManager.listAllGroup(accountNo);

        List<LinkGroupVO> groupVOList = linkGroupDOList.stream().map(obj -> {

            LinkGroupVO linkGroupVO = new LinkGroupVO();
            BeanUtils.copyProperties(obj, linkGroupVO);
            return linkGroupVO;

        }).collect(Collectors.toList());


        return groupVOList;
    }



    @Override
    public int updateById(LinkGroupUpdateRequest request) {

        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();

        LinkGroupDO linkGroupDO = new LinkGroupDO();
        linkGroupDO.setTitle(request.getTitle());
        linkGroupDO.setId(request.getId());
        linkGroupDO.setAccountNo(accountNo);

        int rows = linkGroupManager.updateById(linkGroupDO);

        return rows;
    }


}

