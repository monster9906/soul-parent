package com.soul.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LingCoder
 * @date 2020/7/28 10:23
 */
public class Demo1 {
    static List<String> list =new ArrayList();

    static {
        list.add("aaa");
        list.add("bbb");
        list.add("abc");
        list.add("ccc");
        list.add("ddd");
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"L","i","n","g"};
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> stringStream = Stream.of("L", "i", "n", "g");

//        //Multi-threading
//        list.parallelStream().forEach(ele->{
//            System.out.println(ele);
//        });

        collecting();



    }

    public static void matching(){
        // matching匹配方式
        boolean h = list.stream().anyMatch(ele -> ele.contains("h"));
        boolean h1 = list.stream().allMatch(ele -> ele.contains("h"));
        boolean h2 = list.stream().noneMatch(ele -> ele.contains("h"));

        System.out.printf("anyMatch()：%s,\n allMatch():%s,\n noneMatch():%s\n",h,h1,h2);
    }

    public static void filter(){
        // filter过滤
        Stream<String> d = list.stream().filter(ele -> ele.contains("d"));
        d.forEach(ele-> System.out.println(ele));
    }

    /**
     * map就是对Stream中的值进行再加工，然后将加工过后的值作为新的Stream返回 FlatMap就是将层级关系铺平重来。
     */
    public static void mapping(){
        Stream<String> stringStream = list.stream().map(ele -> convertEle(ele));
        stringStream.forEach(ele->{
            System.out.println(ele);
        });
    }

    private static String convertEle(String ele){
        return ele + "_LingCoder";
    }

    /**
     * reduce()接收两个参数，第一个是开始值，后面是一个函数表示累计。
     */
    public static void reduction(){
        List<Integer> integers = Arrays.asList(1, 2, 3);
        Integer reduce = integers.stream().reduce(100, (a, b) -> a + b);
        System.out.println(reduce);
    }

    public static void collecting(){
        List<String> collect = list.stream().map(ele -> ele.toUpperCase()).collect(Collectors.toList());
        collect.parallelStream().forEach(ele->{
            System.out.println(ele);
        });
    }
}
