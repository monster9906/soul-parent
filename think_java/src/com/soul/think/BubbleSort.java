package com.soul.think;

import java.util.Arrays;

/**
 * @author LingCoder
 * @Description: 冒牌排序
 * @Date 2020/11/22-18:59
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,20,-2};
        boolean flag = false; // 定义标识
        int temp;
        for (int i = 0; i < arr.length - 1; i++) { // 总共需要数组长度-1次排序
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    // 进来一次变为true
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }else {
                flag = false; // 重置为false，以进行下次循环
            }
            System.out.println("第"+(i+1)+"趟排序");
            System.out.println(Arrays.toString(arr));
        }
    }
}
