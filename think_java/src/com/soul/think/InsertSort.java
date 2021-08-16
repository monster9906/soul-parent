package com.soul.think;

import java.util.Arrays;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/24-20:30
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] data = {10,2,20,11};
        insertSort(data);
    }

    private static void insertSort(int[] data){
        for (int i = 1; i < data.length; i++) {
            // 第一个数
            int insertValue = data[i];
            // 第0个数的索引
            int insertIndex = i-1;

            while (insertIndex >= 0 && insertValue < data[insertIndex]){ // 当前要插入的数小于有序列表中的那个数
                // 找到插入的位置，将当前这个位置的值赋值为有序列表中的值，再将索引-1
                data[insertIndex+1] = data[insertIndex];
                insertIndex--;
            }
            // 退出循环时已经找到插入的位置，索引位置+1
            if((insertIndex+1) != i)
            data[insertIndex+1] = insertValue;

            System.out.println("第"+i+"轮后的数组为："+ Arrays.toString(data));
        }
    }
}
