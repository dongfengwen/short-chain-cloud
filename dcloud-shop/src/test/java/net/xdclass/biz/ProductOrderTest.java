package net.xdclass.biz;

import lombok.extern.slf4j.Slf4j;
import net.xdclass.ShopApplication;
import net.xdclass.manager.ProductOrderManager;
import net.xdclass.model.ProductOrderDO;
import net.xdclass.util.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)

@Slf4j
public class ProductOrderTest {

    @Autowired
    private ProductOrderManager productOrderManager;


    @Test
    public void testAdd(){
        for(long i=0L;i<5; i++){
            ProductOrderDO productOrderDO = ProductOrderDO.builder()
                    .outTradeNo(CommonUtil.generateUUID())
                    .payAmount(new BigDecimal(11))
                    .state("NEW")
                    .nickname("小滴课堂-老王 i"+i)
                    .accountNo(100L)
                    .del(0)
                    .productId(2L)
                    .build();

            productOrderManager.add(productOrderDO);
        }

    }



    @Test
    public void testPage(){

        Map<String, Object> page = productOrderManager.page(1, 2, 10L, null);
        log.info(page.toString());

    }

}

