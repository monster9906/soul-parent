package com.soul.container;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author LingCoder
 * @Description: set最常被用在测试归属性
 * @Date 2020/11/6-21:23
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random random = new Random(47);
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            integers.add(random.nextInt(30));
        }
        System.out.println(integers);
    }
}

class SetOperation{
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Collections.addAll(set1,"A B C D E F G H I J K L ".split(" "));
        set1.add("M");
        System.out.println("H:"+set1.contains("H"));
        System.out.println("N:"+set1.contains("N"));

        Set<String> set2 = new HashSet<>();
        Collections.addAll(set2,"H I J K L".split(" "));
        System.out.println("set2 in set1:"+set1.contains(set2));
        set1.removeAll(set2);

        System.out.println("set2 removed from set1:"+set1);
        Collections.addAll(set1,"X Y Z".split(" "));
        System.out.println("x y z add to set1 "+set1);

    }
}