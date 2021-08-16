package com.soul.string;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/12/12-10:50
 */
public class Immutable {
    public static String upcase(String s){
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q= "how are you";
        System.out.println(q);
        // 传递的是拷贝引用
        String upcase = upcase(q);
        System.out.println(upcase);
        System.out.println(q);
    }
}
