package com.soul.think;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/12/22-17:00
 */
public class Prime {
    // 是否停止查找
    static boolean flag = false;

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(nextInt);
        int[] arr = new int[nextInt +1];
        arr[nextInt] = 1 ;

        search(list,arr,nextInt);
    }

    /**
     * @author LingCoder
     * @date 2020/12/22 17:07
     * @description: 判断是否是素数
     */
    private static boolean check(int n){
        int i = 2;
        while (i < n){
            if(n % i == 0){ // 不是素数
                return false;
            }
            i++;
        }
        return true;
    }

    public static void search(LinkedList<Integer> list, int[] arr, int n) {
        for (int i = n - 1; i > 0; i--) {
            if (flag) {
                return;
            }

            if (arr[i] == 1) continue;
            if (check(list.getLast() + i)) {
                list.addLast(i);
                arr[i] = 1;
                if (list.size() == n) {
                    System.out.print("摆成的链是: ");
                    for (Integer integer : list) {
                        System.out.print(integer+" ");
                    }
                    flag = true;
                    return;
                }
                // 继续往下查找
                search(list, arr, n);
                arr[i] = 0;
                list.removeLast();
            }
        }
    }
}
