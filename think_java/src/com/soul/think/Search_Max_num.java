package com.soul.think;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/10-14:20
 */
public class Search_Max_num {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ints = new int[num];
        for (int i = 0; i < num; i++) {
            ints[i] = scanner.nextInt();
        }
        int i = moreAndMin(ints);
        System.out.println("出现次数最多的且最小的数为："+i);
    }

    private static int moreAndMin(int[] arr){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        // 找到最小的数
        int minx = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(minx > map.get(arr[i])){
                minx = map.get(arr[i]);
            }
        }

        // 找到最大次数并且值最小的数
        int res = 0 ,maxkey = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value > res){
                maxkey = key;
                res = value;
            }else  if(value == res){
                if(maxkey > key){
                    maxkey = key;
                    res = value;
                }
            }

        }

        return maxkey;
    }
}
