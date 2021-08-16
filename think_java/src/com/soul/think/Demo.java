package com.soul.think;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/13-14:56
 */
public class Demo {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int X = scanner.nextInt();
//        int Y = scanner.nextInt();
//        if(X > 8 && Y > 5){
//            if(X>16 || Y > 10){
//                System.out.println("引用语句3");
//            }else {
//                return;
//            }
//        }else{
//            if(X > 0 || Y >0){
//                System.out.println("引用语句2");
//            }else{
//                System.out.println("引用语句1"); // 程序块1
//            }
//        }
        int[] arr = new int[]{1,2,3,4,5};
        Demo demo = new Demo();
        int i = demo.binSearch(arr, 3);
        System.out.println(i);

    }


    public int binSearch(int array[], int key) {
        int mid, low, high;
        low = 0;
        high = array.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == array[mid])
                return mid;
            else if (key < array[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }


}
