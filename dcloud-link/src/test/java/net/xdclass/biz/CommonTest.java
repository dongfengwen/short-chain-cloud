package net.xdclass.biz;

import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import net.xdclass.LinkApplication;
import net.xdclass.component.ShortLinkComponent;
import net.xdclass.strategy.ShardingDBConfig;
import net.xdclass.util.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Slf4j
public class CommonTest {


    @Test
    public void testRandomDB(){


//        for(int i=0;i<20;i++){
//            log.info(ShardingDBConfig.getRandomDBPrefix());
//        }


    }


}
