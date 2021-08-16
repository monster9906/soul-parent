package com.soul.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/10/26-16:40
 */
public class Int_array_split_empty {

    public static int findMax(int[] data){
        int k = data.length/2;
        int res=0,res2=0;
        for (int i = 0; i < k; i++) {
            res += data[i]; // 前半部分数组结果累加
        }
        for (int i = k; i < data.length; i++) {
            res2 += data[i];
        }
        return res2-res;
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

    public static int partition(int[] data,int left,int right){
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

    public static void swap(int[] arr ,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void showArr(int[] data,int start,int size){
        for (int i = start; i < size; i++) {
            if(i < size-1){
                System.out.print(data[i]+" ");
            }
            if(i == size-1){
                System.out.print(data[i]);
            }

        }
    }


    public static int partition2(int[] data,int low,int high){
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

    public static int solution(int[] data,int size){
        int low = 0,high = size-1;
        boolean flag = true;
        while (flag){
            int i = partition2(data,low,high);
            if(i == size/2-1){ // 基数位于中间位置
                flag = false;
            }else if(i < size/2-1){ // 在右区间
                low = i+1;
            }else { // 左边区间
                high = i-1;
            }
        }

        int s1=0,s2=0;
        for (int i = 0; i < size/2; i++) {
            s1+=data[i];
        }
        for (int i = size/2; i < size; i++) {
            s2+=data[i];
        }
        return s2-s1;
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[] data = new int[i];
        for (int j = 0; j < i; j++) {
            data[j] = scanner.nextInt();
        }
        // 快速排序
        int solution = solution(data, data.length);
//        quickSort(data,0,data.length-1);
//        int max = findMax(data);
        System.out.println("求解结果："+solution);
        System.out.print("划分结果：A1：");
        showArr(data,0,data.length/2);
        for (int j = 0; j < data.length/2; j++) {
            System.out.print(data[j]+" ");
        }
        System.out.print("\nA2：");
        showArr(data,data.length/2,data.length);

    }

}
