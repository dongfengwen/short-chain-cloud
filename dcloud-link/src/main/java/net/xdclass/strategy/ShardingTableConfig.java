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

public class ShardingTableConfig {

    /**
     * 存储数据表位置编号
     */
    private static final List<String> tableSuffixList = new ArrayList<>();


    //配置启用那些表的后缀
    static {
        tableSuffixList.add("0");
        tableSuffixList.add("a");
    }


    /**
     * 获取随机的后缀
     * @return
     */
    public static String getRandomTableSuffix(String code ){

        int hashCode = code.hashCode();

        int index = Math.abs(hashCode) % tableSuffixList.size();

        return tableSuffixList.get(index);
    }



}
