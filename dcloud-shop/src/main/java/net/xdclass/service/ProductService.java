package net.xdclass.service;

import net.xdclass.vo.ProductVO;

import java.util.List;

public interface ProductService {


    List<ProductVO> list();

    ProductVO findDetailById(long productId);
}
