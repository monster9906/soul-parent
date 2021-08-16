package com.soul.think;

import java.util.Arrays;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/22-20:37
 */
public class SortSeclect {
    public static void main(String[] args) {
        int[] arr= {99,11,1,85};

        for (int i = 0; i < arr.length - 1; i++) {
            // 假定第一个就是最小数
            int min = arr[i];
            int minIndex = i;

            for (int j = i+1; j < arr.length; j++) {
                if(min > arr[j]){
                    // 替换最小值和最小值下标索引
                   min = arr[j];
                   minIndex = j;
                }
            }

            if(minIndex != i){//　发生位置变动后，才进行数据交换
                // 在相互交换位置
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第"+(i+1)+"轮数据为：");
            System.out.println(Arrays.toString(arr));
        }
    }
}
