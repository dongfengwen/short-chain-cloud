package net.xdclass.biz;

import lombok.extern.slf4j.Slf4j;
import net.xdclass.AccountApplication;
import net.xdclass.manager.TrafficManager;
import net.xdclass.mapper.TrafficMapper;
import net.xdclass.model.TrafficDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
@Slf4j
public class TrafficTest {


    @Autowired
    private TrafficMapper trafficMapper;

    @Autowired
    private TrafficManager trafficManager;

    @Test
    public void testSaveTraffic() {

        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            TrafficDO trafficDO = new TrafficDO();
            trafficDO.setAccountNo(Long.valueOf(random.nextInt(100)));
            trafficMapper.insert(trafficDO);
        }

    }


    @Test
    public void testDeleteExpiredTraffic(){

        trafficManager.deleteExpireTraffic();

    }



    @Test
    public void testSelectAvailableTraffics(){

        List<TrafficDO> list = trafficManager.selectAvailableTraffics(693100647796441088L);
        list.stream().forEach(obj->{
            log.info(obj.toString());
        });

    }


    @Test
    public void testAddDayUsedTimes(){

        int rows = trafficManager.addDayUsedTimes(693100647796441088L,1486221880318595076L,1);

        log.info("rows={}",rows);
    }



    @Test
    public void testReleaseDayUsedTimes(){

        int rows = trafficManager.releaseUsedTimes(693100647796441088L,1486221880318595076L,1,"");

        log.info("rows={}",rows);
    }


    @Test
    public void testBatchUpdateUsedTimes(){
        List<Long> list = new ArrayList<>();
        list.add(1486221880318595076L);
        int rows = trafficManager.batchUpdateUsedTimes(693100647796441088L,list);
        log.info("rows={}",rows);

    }

}
