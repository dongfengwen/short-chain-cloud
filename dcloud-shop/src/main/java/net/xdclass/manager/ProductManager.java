package net.xdclass.manager;

import net.xdclass.model.ProductDO;

import java.util.List;

public interface ProductManager {

    List<ProductDO> list();

    ProductDO findDetailById(long productId);
}
