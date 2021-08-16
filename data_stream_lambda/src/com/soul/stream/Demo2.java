package com.soul.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author LingCoder
 * @date 2020/7/28 12:02
 */
public class Demo2 {

   static List<String> list = Arrays.asList("jack", "bob", "alice", "mark");

   static List<String> duplicateList = Arrays.asList("jack", "jack", "alice", "mark");


    public static void main(String[] args) {
        List<String> collect = list.stream() .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(collect);

        Set<String> collect1 = list.stream().collect(Collectors.toSet());
        System.out.println(collect1);

        Map<String, Integer> collect2 = list.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(collect2);

        ArrayList<String> collect3 = list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    return new ArrayList<>(l);
                }));
        System.out.println(collect3);

        String collect4 = list.stream().collect(Collectors.joining("||", "pre", "suf"));
        System.out.println(collect4);

        // 统计个数
        Long collect5 = list.stream().collect(Collectors.counting());
        System.out.println(collect5);

        IntSummaryStatistics collect6 = list.stream().collect(Collectors.summarizingInt(String::length));
        System.out.println(collect6);

        Optional<String> collect7 = list.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(collect7);

        Map<Integer, List<String>> collect8 = list.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
        System.out.println(collect8);

    }



}
