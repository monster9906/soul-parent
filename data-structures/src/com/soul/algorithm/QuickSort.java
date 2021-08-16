package com.soul.algorithm;

import com.sun.deploy.util.SyncAccess;

import java.util.Scanner;
import java.util.logging.Level;

/**
 * @author LingCoder
 * @Description: 快速排序
 * @Date 2020/10/12-17:44
 */
public class QuickSort {
    public static void main(String[] args) {

//        int[] data = {15,13,12,100,20};
        int[] data = new int[]{5,1,2,3,4,5};
        showArr(data);
        quickSort(data,0,data.length-1);
        System.out.println("\n===================");
        showArr(data);

    }

    public static  int partition(int[] data,int start,int end){
        if(data == null){
            return 0;
        }
        // 基数
        int temp = data[start];

        while (start<end){
            // 先判断基数和后面的数依次做比较
            while(temp <= data[end] && start<end){
                end--;
            }
            // 基数大于arr[end] 填坑
            if(start < end){
                data[start] = data[end];
                start++;
            }
            // 填坑arr[end]
            while (temp >data[start] && start<end){
                start++;
            }
            if(start < end){
                data[end] = data[start];
                end--;
            }

        }
        data[start] = temp;

        return start;
    }


    public static void quickSort(int[] data,int start ,int end){
        // 数据为空则返回
        if(data== null || data.length<=0 || start>=end){
            return;
        }
        int mid = partition(data, start, end);
        quickSort(data,start,mid);
        quickSort(data,mid+1,end);
    }

    public static void showArr(int[] data){
        for (int i : data) {
            System.out.print(i+" ");
        }

    }

    public static void swap(int[] arr ,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @author LingCoder
     * @date 2020/10/18 20:09
     * @description: 三数取中的方法实现
     * @return void
     */
    public static int partition2(int[] data,int left,int right){
        // 采用三数中值分割法
        int mid = left+(right-left)/2;
        // 保证左端较小
        if(data[left]>data[right]){
            swap(data,left,right);
        }
        //保证中间较小
        if(data[mid]>data[right]){
            swap(data,mid,right);
        }
        // 保证中间最小，左右较大
        if(data[mid] > data[left]){
            swap(data,left,mid);
        }

        // 基数
        int pivot = data[left];

        while (left < right){
            // 先判断基准数和后面的数依次比较
            while (pivot <= data[right] && left < right){
                right--;
            }
            // 基数大于后边的数据填坑
            if(left < right){
                data[left] = data[right];
                left++;
            }

            // 再判断基数和前边的数据做比较
            while (pivot >= data[left] && left < right){
                left ++;
            }

            if(left < right){
                data[right] = data[left];
                right --;
            }
      }
        data[left] = pivot;
        return left;
    }

}
