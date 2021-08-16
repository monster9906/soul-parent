package com.soul.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/29-21:03
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,5,6,8,99,102,200,200,200,300};
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 200);
        System.out.println(list.toString());
    }

    /**
     * @author LingCoder
     * @date 2020/11/29 21:09
     * @description:
     * @param arr 有序的数组
     * @param left 数组查找左边下标
     * @param right 数组查找右边下标
     * @param findValue 待查找的指
     */
    private static int binarySearch(int[] arr,int left,int right,int findValue){
        int mid = (left+right)/2;
        int midValue = arr[mid];

        if(left > right){
            return -1;
        }

        if(findValue > midValue){ // 向右递归
           return binarySearch(arr,mid+1,right,findValue);
        }else if(findValue < midValue){ // 向左递归
           return binarySearch(arr,left,mid-1,findValue);
        }else {
            return mid;
        }
    }

    private static List<Integer> binarySearch2(int[] arr, int left, int right, int findValue){
        int mid = (left+right)/2;
        int midValue = arr[mid];

        if(left > right){
            return new ArrayList<Integer>();
        }

        if(findValue > midValue){ // 向右递归
            return binarySearch2(arr,mid+1,right,findValue);
        }else if(findValue < midValue){ // 向左递归
            return binarySearch2(arr,left,mid-1,findValue);
        }else {
            List<Integer> list = new ArrayList<>();
            // 向查找到的值的左边递归
            int temp = mid-1;
            while (true){
                if(temp < 0 || arr[temp] != findValue){
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            // 保证mid在集合的中间
            list.add(mid);

            // 向右递归
            temp = mid +1;
            while (true){
                if(temp > arr.length-1 || arr[temp] != findValue){ // 退出
                    break;
                }
                list.add(temp);
                temp += 1;
            }

            return list;
        }
    }

}
