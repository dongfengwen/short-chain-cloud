package net.xdclass.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Configuration
@Slf4j
public class SnowFlakeWordIdConfig {


    /**
     * 动态指定sharding jdbc 的雪花算法中的属性work.id属性
     * 通过调用System.setProperty()的方式实现,可用容器的 id 或者机器标识位
     * workId最大值 1L << 100，就是1024，即 0<= workId < 1024
     * {@link SnowflakeShardingKeyGenerator#getWorkerId()}
     *
     */
    static {

        try {
            InetAddress inetAddress = Inet4Address.getLocalHost();

            String hostAddressIp = inetAddress.getHostAddress();

            String workId = Math.abs(hostAddressIp.hashCode()) % 1024+"";

            System.setProperty("workId",workId);

            log.info("workId:{}",workId);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }




//    public static void main(String [] args){
//
//        InetAddress inetAddress = null;
//        try {
//            inetAddress = Inet4Address.getLocalHost();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        System.out.println(inetAddress.getHostAddress());
//        System.out.println(inetAddress.getHostName());
//
//    }


}
