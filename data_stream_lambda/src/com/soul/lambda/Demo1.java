package com.soul.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LingCoder
 * @date 2020/7/28 10:58
 */
public class Demo1 {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(()->{
//            System.out.println("new runnable");
//        });

//        inForEach();
    }


    public static String test(String string,Usage usage){
        return usage.method(string);
    }

    public static String test1(String s , Function<String,String> fn){
        return fn.apply(s);
    }

    public static void bifunction(){
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("alice", 100);
        salaries.put("jack", 200);
        salaries.put("mark", 300);

        salaries.replaceAll((name,oldVal)->
            name.equals("jack") ? oldVal : oldVal + 100
        );

        salaries.forEach((name,age)-> System.out.println(name +"is "+ age +" years old "));
        //System.out.println(salaries);

    }

    public static void predicate(){
        //Predicate
        List<String> names = Arrays.asList("A", "B", "C", "D", "E");
        List<String> namesWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(namesWithA);
    }

    public static void inForEach(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> evenIntegers = integers.stream().filter(integer -> integer % 2 == 0);

        Stream<Integer> integerStream = integers.stream().filter(integer -> integer % 2 != 0);

        evenIntegers.forEach(integer -> System.out.println(integer));
        integerStream.forEach(integer -> System.out.println(integer));
    }
}
