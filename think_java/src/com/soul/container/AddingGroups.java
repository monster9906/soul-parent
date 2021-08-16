package com.soul.container;

import java.util.*;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/6-12:20
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        // 定义数组
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection,moreInts);

        // 底层表示的是数组  不能改变大小，对它所产生的list做出最理想的假设
        List<Integer> integers = Arrays.asList(16, 17, 18, 19);
        integers.set(1,100);
        // java.lang.UnsupportedOperationException
//        integers.add(88);

        System.out.println(collection);
        System.out.println(integers);
    }
}
