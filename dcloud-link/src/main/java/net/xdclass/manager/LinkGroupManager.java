package net.xdclass.manager;

import net.xdclass.model.LinkGroupDO;

import java.util.List;

public interface LinkGroupManager {

    int add(LinkGroupDO linkGroupDO);

    int del(Long groupId, Long accountNo);

    LinkGroupDO detail(Long groupId, Long accountNo);

    List<LinkGroupDO> listAllGroup(Long accountNo);

    int updateById(LinkGroupDO linkGroupDO);
}
