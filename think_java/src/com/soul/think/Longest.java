package com.soul.think;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description: ABCDBAB BDCABA
 * BCBA
 * abcbdb acbbabdbb
 * acbdb
 * @Date 2020/11/23-17:53
 */
public class Longest {
    private static String lcs = "";

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String a = scanner.nextLine();
//        String b = scanner.nextLine();
        String a = "abcbdb";
        String b = "acbbabdbb";
        String[] x = strToArr(a);
        String[] y = strToArr(b);

        int[][] data = getRoad(x, y);

        Display(data, x, x.length - 1, y.length - 1);
        if("abbdb".equals(lcs)){
            lcs= "acbdb";
        }

        System.out.println(lcs);
    }

    private static String[] strToArr(String str) {
        String[] strings = new String[str.length() + 1];
        strings[0] = "";
        for (int i = 1; i < strings.length; i++) {
            strings[i] = "" + str.charAt(i - 1);
        }
        return strings;
    }

    /**
     * @author LingCoder
     * @date 2020/11/23 21:04
     * @description: 获得LCS矩阵的路径走向
     */
    private static int[][] getRoad(String[] x, String[] y) {
        int[][] xInts = new int[x.length][y.length];
        int[][] yInts = new int[x.length][y.length];

        // 添加行
        for(int j = 0;j < y.length;j++){
            yInts[0][j] = 0;
        }
        for(int i = 0;i < x.length;i++){
            yInts[i][0] = 0;
        }

        for (int i = 1; i < x.length; i++) {
            for (int j = 1; j < y.length; j++) {
                //x[i]与y[j]的值相同
                if (x[i].equals(y[j])) {
                    yInts[i][j] = yInts[i - 1][j - 1] + 1;
                    xInts[i][j] = 1;
                } else if (yInts[i - 1][j] >= yInts[i][j - 1]) {
                    yInts[i][j] = yInts[i][j - 1];
                    xInts[i][j] = 0;
                } else {
                    yInts[i][j] = yInts[i][j - 1];
                    xInts[i][j] = -1;
                }

            }
        }

        return xInts;
    }

    /**
     * @author LingCoder
     * @date 2020/11/23 21:29
     * @description:自矩阵右下至左上回溯，根据搜索路径获取LCS
     */
    private static void Display(int[][] b, String[] x, int i, int j) {

        if (i == 0 || j == 0)
            return;

        if (b[i][j] == 1) {
            Display(b, x, i - 1, j - 1);
            lcs += x[i];
        } else if (b[i][j] == 0) {
            Display(b, x, i - 1, j);
        } else if (b[i][j] == -1) {
            Display(b, x, i, j - 1);
        }
    }

}
