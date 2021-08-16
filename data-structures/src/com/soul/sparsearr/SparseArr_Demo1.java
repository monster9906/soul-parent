package com.soul.sparsearr;

/**
 * @author 符浩灵
 * @date 2020/7/4 12:38
 *  二维数组转稀疏数组  统计
 */
public class SparseArr_Demo1 {
    public static void main(String[] args) {
        // 创建一个二维数组 0 是默认 1-蓝 2 黑
        int[][] charArr = new int[11][11];
        charArr[1][2] = 1;
        charArr[2][3] = 2;

        // 输出原始数组
        for (int[] ints : charArr) {
            for (int i : ints) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
        // 获取非0总数
        int sum = 0;
        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j < charArr.length; j++) {
                if(charArr[i][j] != 0){
                    sum ++;
                }
            }
        }

       // 创建一个稀疏数组  col1:行 col2:列 col3:值
       int[][] sparseArr = new int[sum+1][3];
       sparseArr[0][0] = charArr.length;
       sparseArr[0][1] = charArr.length;
       sparseArr[0][2] = sum;

       // 遍历二维数组 将二维数组中的非0的值放到稀疏数组中
        int count = 0;
        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j < charArr.length; j++) {
                if(charArr[i][j] != 0){
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = charArr[i][j];
                }
            }
        }

        // 输出稀疏数组
        System.out.println("~~~~~~~~~~~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        System.out.println("~~~~~~~~~~~~~~~");

        //从稀疏数组中还原原来的二维数组
        int[][] charArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 从稀疏数组的第二行开始
        for (int i = 1; i < sparseArr.length; i++) {
            charArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //遍历这个还原后的数组
        for (int[] ints : charArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }



    }
}
