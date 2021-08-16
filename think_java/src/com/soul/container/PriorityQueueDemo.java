package com.soul.container;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.*;

/**
 * @author LingCoder
 * @Description: 可以指定队列中元素的顺序,重复是允许的 最小的拥有最高的优先级
 *  字符串中 空格的优先级比字符串高
 * @Date 2020/11/8-13:12
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> objects = new PriorityQueue<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            objects.offer(random.nextInt(i+10));
        }
        QueueDemo.PrintQ(objects);

        List<Integer> integers = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        objects = new PriorityQueue<>(integers);
        QueueDemo.PrintQ(objects);

        objects = new PriorityQueue<>(integers.size(), Collections.reverseOrder());
        objects.addAll(integers);
        QueueDemo.PrintQ(objects);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> list = Arrays.asList(fact.split(" "));
        PriorityQueue<String> strings = new PriorityQueue<>(list);
        QueueDemo.PrintQ(strings);

        // 去除重复的元素
        Set<Character> characterSet = new HashSet<>();
        for (char c : fact.toCharArray()) {
            characterSet.add(c);
        }
        PriorityQueue<Character> characters = new PriorityQueue<>(characterSet);
        QueueDemo.PrintQ(characters);

    }
}
