package com.soul.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LingCoder
 * @Description: 插值查找
 * @Date 2020/11/29-21:46
 *  int mid = left + (right-left) * (findValue - arr[left]) / (arr[right] - arr[left])
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list = insertValueSearch(arr, 0, arr.length - 1, 2);

        System.out.println(list);
    }

    private static List<Integer> insertValueSearch(int[] arr,int left,int right,int findValue){
       if(left > right || findValue > arr[arr.length-1] || findValue < arr[0]){
            return new ArrayList<>();
       }
        int mid = left + (right-left) * (findValue -arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        if(findValue < midValue){ // 向左递归
            return insertValueSearch(arr,left,mid-1,findValue);
        }else if(findValue > midValue){ // 向右递归
            return insertValueSearch(arr,mid+1, right,findValue);
        }else {
            List<Integer> list = new ArrayList<>();

            // 向左递归
            int temp = mid-1;
            while (true){
                if(temp < 0 || findValue != arr[temp]){
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            list.add(mid);

            temp = mid +1;
            // 向右递归
            while (true){
                if(temp > arr.length-1 || findValue != arr[temp]){
                    break;
                }
                list.add(temp);
                temp += 1;
            }

            return list;
        }

    }
}
