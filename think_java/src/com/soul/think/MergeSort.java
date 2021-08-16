package com.soul.think;

import java.util.Arrays;

/**
 * @author LingCoder
 * @Description: 归并排序
 * @Date 2020/11/26-23:14
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @author LingCoder
     * @date 2020/11/26 23:45
     * @description: 分解数组
     */
    private static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            // 获取中间变量
            int mid = (left + right)/2;
            // 向左分解
            mergeSort(arr,left,mid,temp);
            // 向右分解
            mergeSort(arr,mid+1,right,temp);
            // 进行合并操作
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * @author LingCoder
     * @date 2020/11/26 23:23
     * @description: 合并数组
     * @param arr 原始数组
     * @param left 左边数组初始索引
     * @param mid 数组中间索引
     * @param right 右边的索引
     * @param temp 顺序插入的保存的临时数组
     */
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;// 左边数组移动索引
        int j = mid+1;// 右边数组移动初始索引
        int tempIndex = 0;// 临时数组下标移动索引
        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){ // 左边的值小于等于右边的值就将左边的值插入临时数组
                temp[tempIndex] = arr[i];
                i += 1;
                tempIndex += 1;
            }else {
                temp[tempIndex] = arr[j];
                j += 1;
                tempIndex +=1;
            }
        }

        // 处理有一边未填充完的数据
        while (i <= mid) {
            temp[tempIndex] = arr[i];
            i += 1;
            tempIndex += 1;
        }
        while (j <= right){
            temp[tempIndex] = arr[j];
            j += 1;
            tempIndex += 1;
        }

        // 将临时数组中的数组copy到原数组中
        tempIndex = 0;
        int tempLeft = left;
        System.out.println("tempLeft="+tempLeft+" right="+right);
        while (tempLeft <= right){// 索引未全部遍历完
            arr[tempLeft] = temp[tempIndex];
            tempLeft += 1;
            tempIndex += 1;
        }
    }
}
