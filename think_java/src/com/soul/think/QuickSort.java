package com.soul.think;

import java.util.Arrays;

/**
 * @author LingCoder
 * @Description: 快速排序
 * @Date 2020/11/25-14:08
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @author LingCoder
     * @date 2020/11/25 16:51
     * @description: 不断的将需要排序的数组分为两组
     */
    private static void quick(int[] arr ,int left,int right){
        int l = left;
        int r = right;
        // 中间阈值
        int pivot = arr[(left+right)/2];
        int temp =0; // 临时变量

        while (l < r){
            // 在阈值左边找到比阈值大的数
            while (arr[l] < pivot){
                l += 1;
            }
            // 在阈值左边找到比阈值小的数
            while (arr[r] > pivot){
                r -= 1;
            }
            if(l >= r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果arr[l] = pivot r--，前移
            if(arr[l] == pivot){
                r -= 1;
            }
            // 如果arr[r] = pivot l++，后移
            if(arr[r] == pivot){
                l += 1;
            }
        }

        // 避免栈溢出
        if(l == r){
            l += 1;
            r -= 1;
        }

        // 向左递归
        if(left < r){
            quick(arr,left,r);
        }
        // 向右递归
        if(right > l){
            quick(arr,l,right);
        }

    }

}
