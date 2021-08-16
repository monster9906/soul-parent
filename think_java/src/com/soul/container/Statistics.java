package com.soul.container;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/6-21:57
 */
public class Statistics {
    public static void main(String[] args) {
        Random random = new Random(47);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int i1 = random.nextInt(20);
            Integer integer = map.get(i1);
            map.put(i1,integer == null ?1:integer+1);
        }
        System.out.println(map);
    }
}
