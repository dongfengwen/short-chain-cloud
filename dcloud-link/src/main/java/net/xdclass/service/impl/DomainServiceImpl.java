package net.xdclass.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.xdclass.interceptor.LoginInterceptor;
import net.xdclass.manager.DomainManager;
import net.xdclass.model.DomainDO;
import net.xdclass.service.DomainService;
import net.xdclass.vo.DomainVO;
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
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainManager domainManager;


    @Override
    public List<DomainVO> listAll() {
        Long accountNo = LoginInterceptor.threadLocal.get().getAccountNo();

        List<DomainDO> customDomainList = domainManager.listCustomDomain(accountNo);
        List<DomainDO> officialDomainList = domainManager.listOfficialDomain();

        customDomainList.addAll(officialDomainList);

        return customDomainList.stream().map(obj-> beanProcess(obj)).collect(Collectors.toList());
    }


    private DomainVO beanProcess(DomainDO domainDO){

        DomainVO domainVO = new DomainVO();

        BeanUtils.copyProperties(domainDO,domainVO);

        return domainVO;

    }

}
