package com.soul.stream;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LingCoder
 * @date 2020/8/6 16:48
 *  自定义Collectors
 *
 *  Supplier是一个函数，用来创建一个新的可变的集合。换句话说Supplier用来创建一个初始的集合。
 *  accumulator定义了累加器，用来将原始元素添加到集合中。
 *  combiner用来将两个集合合并成一个。
 *  finisher将集合转换为最终的集合类型。
 *  characteristics表示该集合的特征。这个不是必须的参数
 */
public class CustomizeCollectors {
    public static <T> Collector<T, Set<T>,Set<T>> toImmutableSet(){
        return Collector.of(HashSet::new, Set::add, (left,right) ->{
                left.addAll(right);
                return left;
        }, Collections::unmodifiableSet);
    }

    public static void main(String[] args) {
        Set<String> collect = Stream.of("a", "b", "c", "d").collect(CustomizeCollectors.toImmutableSet());
        System.out.println(collect);

    }
}
