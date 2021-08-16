package com.soul.think;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * 6
 * 30 35
 * 35 15
 * 15 5
 * 5 10
 * 10 20
 * 20 25
 * m[1][6]=15125
 * @Date 2020/11/23-21:52
 */
public class matrixmulti {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]=new int[n];
        int arrayA[][]=new int[n][n];
        int arrayB[][]=new int[n][n];
        for(int i=0;i<n;i++) {
            array[i]=sc.nextInt();
        }

        int res=solve(array,arrayA,arrayB);
        System.out.println(" m[1][6]="+res);

    }

    /**
     * @author LingCoder
     * @date 2020/11/23 22:02
     * @description: 获取最大值
     */
    private static int solve(int[] array, int[][] arrayA,int arrayB[][]) {
        int n=array.length-1;
        for(int i=1;i<=n;i++) {
            arrayA[i][i]=0;//对角线设置为0
        }
        for(int r=2;r<=n;r++) {//r控制的是行数,用来协调i和j
            for(int i=1;i<=n-r+1;i++) {
                int j=r+i-1;//j最小从2开始
                arrayA[i][j]=arrayA[i+1][j]+array[i-1]*array[i]*array[j];
                arrayB[i][j]=i;
                for(int k=i+1;k<j;k++) {
                    int t=arrayA[i][k]+arrayA[k+1][j]+array[i-1]*array[k]*array[j];
                    if(t<arrayA[i][j]) {
                        arrayA[i][j]=t;
                        arrayB[i][j]=k;
                    }
                }

            }
        }
        return arrayA[1][n];
    }
}
