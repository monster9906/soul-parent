package com.soul.container;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * @author LingCoder
 * @Description: 打印容器内容
 * @Date 2020/11/6-12:52
 */
public class PrintContainers {
    static Collection fill(Collection<String> collection){
        collection.add("詹姆斯");
        collection.add("浓眉");
        collection.add("欧文");
        collection.add("欧文");
        return collection;
    }

    static Map fill(Map<String,String> map){
        map.put("nba","湖人");
        map.put("cat","蓝猫");
        map.put("dog","拉布拉多");
        map.put("dog","阿拉斯加");
        return map;
    }

    public static void main(String[] args) {
        // [詹姆斯, 浓眉, 欧文, 欧文]
        System.out.println(fill(new ArrayList<>()));
        // ArrayList 和 LinkedList  操作某些数据类型时的性能不一样 LinkedList支持的操作更多
        //[詹姆斯, 浓眉, 欧文, 欧文]
        System.out.println(fill(new LinkedList<>()));

        // [詹姆斯, 浓眉, 欧文] 获取元素最快
        System.out.println(fill(new HashSet<>()));

        //[欧文, 浓眉, 詹姆斯] 按照比较结果的升序保存对象
        System.out.println(fill(new TreeSet<>()));

        // [詹姆斯, 浓眉, 欧文] 按添加的顺序报错对象
        System.out.println(fill(new LinkedHashSet<>()));

        // {cat=蓝猫, nba=湖人, dog=阿拉斯加} 保存顺序不是插入的顺序 查找速度最快
        System.out.println(fill(new HashMap<>()));

        // {cat=蓝猫, dog=阿拉斯加, nba=湖人} 按照比较结果的升序保存数据
        System.out.println(fill(new TreeMap<>()));

        // {nba=湖人, cat=蓝猫, dog=阿拉斯加} 保存插入的顺序也保留HashMap的速度
        System.out.println(fill(new LinkedHashMap<>()));
    }

}
