package net.xdclass.strategy;

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

public class ShardingDBConfig {

    /**
     * 存储数据库位置编号
     */
    private static final List<String> dbPrefixList = new ArrayList<>();


    //配置启用那些库的前缀
    static {
        dbPrefixList.add("0");
        dbPrefixList.add("1");
        dbPrefixList.add("a");


//        dbPrefixList.add("b");
//        dbPrefixList.add("c");
//        dbPrefixList.add("b");
//        dbPrefixList.add("c");
//        dbPrefixList.add("b");
//        dbPrefixList.add("c");
//        dbPrefixList.add("b");
//        dbPrefixList.add("c");
    }


    /**
     * 获取随机的前缀
     * @return
     */
    public static String getRandomDBPrefix(String code){

        int hashCode = code.hashCode();

        int index = Math.abs(hashCode) % dbPrefixList.size();

        return dbPrefixList.get(index);
    }



}
