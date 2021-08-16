package com.soul.string;

import java.util.Random;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/12/12-14:19
 */
public class UsingStringBuilder {
    public static void main(String[] args) {

        String s1 = "sa";
        String s2 = "SA";
        System.out.println(s1.contentEquals(s2));
        System.out.println(s1.compareTo(s2));
//        UsingStringBuilder usingStringBuilder = new UsingStringBuilder();
//        System.out.println(usingStringBuilder.toString());
    }
    public static Random random = new Random(47);
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            stringBuilder.append(random.nextInt(100));
            stringBuilder.append(", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
