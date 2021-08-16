package com.soul.think;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/12/22-16:48
 */
public class Nqueens {
    static boolean flag = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        System.out.println(nextInt + "皇后问题共有" + Nqueens(nextInt) + "种摆放方案");
    }

    /**
     * @author LingCoder
     * @date 2020/12/22 16:54
     * @description: 填充位置数组
     */
    private static int Nqueens(int n){
        int result = 0;
        int[][] arr = new int[n][2];//0 号位等于1代表是否初次调用
        int row = 0;
        while (arr[0][1] < n) {
            int b = 0, j = arr[row][0] == 0 ? 0 : arr[row][1] + 1;
            for (; j < n; j++) {
                if (check(arr, row, j)){
                    continue;
                }
                arr[row][1] = j;
                arr[row][0] = 1;
                row++;
                b = 1;
                break;
            }
            if (j == n && b == 0) {//回滚
                if (row == 0) {
                    return result;
                }
                arr[row][1] = 0;
                arr[row][0] = 0;
                row--;
            }
            if (row == n && b == 1) {
                result += 1;
                print(arr, n);
                row--;
                arr[row][1] = 0;
                arr[row][0] = 0;
                row--;
            }
        }
        return result;
    }

    /**
     * @author LingCoder
     * @date 2020/12/22 16:55
     * @description: 检查皇后的位置是否符合位置
     */
    private static boolean check(int[][] arr, int row, int idx) {
        for (int i = 0; i < row; i++) {
            if (idx == arr[i][1]) {
                return true;
            }
            if ((row - idx) == (i - arr[i][1])) {
                return true;
            }
            if ((row + idx) == (i + arr[i][1])) {
                return true;
            }
        }
        return false;
    }

    /**
     * @author LingCoder
     * @date 2020/12/22 16:55
     * @description:输出
     */
    private static void print(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (n == 4 && flag) {
                    flag = false;
                } else {
                    System.out.print("  ");
                }
                if (arr[i][1] == j)
                    System.out.print("Q");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

}
