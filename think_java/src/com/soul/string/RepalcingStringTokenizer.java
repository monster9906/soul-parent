package com.soul.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Rich_fu
 * @date 2021/3/12 泛型
 */
public class RepalcingStringTokenizer {
    public static void main(String[] args) {
        String input = "but i'm not dead yet! i fell so happy";
        StringTokenizer stringTokenizer = new StringTokenizer(input);
        while (stringTokenizer.hasMoreElements()){
            System.out.print(stringTokenizer.nextToken()+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(input.split(" ")));
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()){
            System.out.println(scanner.next() + " ");
        }
    }

}
