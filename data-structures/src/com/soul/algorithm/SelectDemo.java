package com.soul.algorithm;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/10/27-19:49
 */
public class SelectDemo {

    public static int partition(int[] data,int low,int high){
        int i = low,j=high;
        // 基数
        int povit = data[low];
        while (i <j){
            while (i<j && data[j] >= povit){
                j--;
            }
            data[i] = data[j];

            while (i <j && data[i] <= povit){
                i++;
            }
            data[j] = data[i];
        }
        data[i] = povit;
        return i;
    }

    public static void swap(int[] arr ,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

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

    public static int select(int[] data,int low,int high,int k ){
        if(low == high && k ==1){
            return data[low];
        }
        int j = partition2(data,low,high);
        int p = j-low+1;
        if(k<=p){
            return select(data,low,j,k);
        }else {
            return select(data,j+1,high,k-p);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 10;
        int e;
        int k =scanner.nextInt();
        int[] data = {2,5,1,7,10,6,9,4,3,8};

        e = select(data,0,n-1,3);
        System.out.printf("第%d小的元素:%d\n",k,e);
    }
}
