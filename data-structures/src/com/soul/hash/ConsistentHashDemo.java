package com.soul.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author LingCoder
 * @Description: 一致性hash算法
 * @Date 2020/9/22-22:36
 */
public class ConsistentHashDemo {

    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {"10.0.0.1", "10.0.0.2", "10.0.0.3"};

    /**
     * key表示服务器的hash值，value表示服务器
     */
    private static SortedMap<Integer,String> sortedMap = new TreeMap<Integer,String>();

    /**
     * 程序初始化，将所有的服务器放入sortedMap中
     */
    static {
        for (int i = 0; i < servers.length; i++) {
            int hash = getHash(servers[i]);
            System.out.printf("%s 加入到map中，其hash值为：%d\n",servers[i],hash);
            sortedMap.put(hash,servers[i]);
        }
    }

    /**
     * @author LingCoder
     * @date 2020/9/22 22:42
     * @description: 使用FNV1_32_HASH算法计算Hash值(网上找的标准算法)
     * @return int
     */
    private static int getHash(String str){
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    /**
     * @author LingCoder
     * @date 2020/9/22 22:46
     * @description: 通过hashkey值获取到对应的服务
     * @return java.lang.String
     */
    private static String getServer(String key){
        //得到该key的hash值
        int hash = getHash(key);
        //得到大于该Hash值的所有Map，这里用有排序功能的sortedMap，有很多api很方便
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        if(subMap.isEmpty()){
            //如果没有比该key的hash值大的，则从第一个node开始
            Integer i = sortedMap.firstKey();
            //返回对应的服务器
            return sortedMap.get(i);
        }else{
            //第一个Key就是顺时针过去离node最近的那个结点
            Integer i = subMap.firstKey();
            //返回对应的服务器
            return subMap.get(i);
        }

    }

    public static void main(String[] args) {
        String[] keys = {"医生", "护士", "患者"};
        for(int i=0; i<keys.length; i++) {
            System.out.println("[" + keys[i] + "]的hash值为" + getHash(keys[i])
                    + ", 被路由到结点[" + getServer(keys[i]) + "]");
        }

    }



}
