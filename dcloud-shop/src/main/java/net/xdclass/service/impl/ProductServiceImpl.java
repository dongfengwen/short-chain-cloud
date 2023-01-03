package net.xdclass.service.impl;

import groovy.util.logging.Slf4j;
import net.xdclass.manager.ProductManager;
import net.xdclass.model.ProductDO;
import net.xdclass.service.ProductService;
import net.xdclass.vo.ProductVO;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductManager productManager;

    @Override
    public List<ProductVO> list() {

        List<ProductDO> list = productManager.list();

        List<ProductVO> collect = list.stream().map( obj -> beanProcess(obj) ).collect(Collectors.toList());


        return collect;
    }

    @Override
    public ProductVO findDetailById(long productId) {

        ProductDO productDO = productManager.findDetailById(productId);

        ProductVO productVO = beanProcess(productDO);

        return productVO;
    }


    private ProductVO beanProcess(ProductDO productDO) {

        ProductVO productVO = new ProductVO();

        BeanUtils.copyProperties(productDO, productVO);
        return productVO;
    }

}
