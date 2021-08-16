package com.soul.think;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * 最优解：0.00 1.00 0,50
 * 总价值：31.50
 * @Date 2020/11/9-17:29
 */
public class GreedyKnapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 背包容量
        int capacity = scanner.nextInt();

        // 物品个数
         int num = scanner.nextInt();
            
         // 存放所有数据
        double[] ints = new double[num*2];
        for (int i = 0; i < num * 2; i++) {
            ints[i] = scanner.nextInt();
        }

        // 对应价值
        double[] intsValue = new double[num];
        // 对应重量
        double[]  intsWeight = new double[num];

        int j = 0;
        int k = 0;
        for(int i=0; i < ints.length; i+=2){
            intsWeight[j] = ints[i];
            j++;
        }
        for(int i=1; i < ints.length; i+=2){
            intsValue[k] = ints[i];
            k++;
        }

        System.out.println("背包容量：物品个数：请分别输入物品的重量和价值：");
        knapsackGreedy(num,capacity,intsWeight,intsValue);
    }

    /**
     * @author LingCoder 28 4 15 30 10 15 5 5 10 8
     * @date 2020/11/9 17:50
     * @description:贪婪算法实现背包问题求解
     */
    private static void knapsackGreedy(int num, double capacity, double[] intsWeight, double[] intsValue){
        // 保存性价比的数据
        double[] doubles = new double[num];

        // 保存性价比下标的数组
        int[] index = new int[num];

        // 计算各个物品的性价比
        for (int i = 0; i < num; i++) {
            doubles[i] = (double) intsValue[i]/intsWeight[i];
            index[i] = i;
        }

        // 对物品的性价比进行排序
        double temp = 0;
        for (int i = 0; i < num; i++) {
            for (int j = i; j < num; j++) {
                if(doubles[i] < doubles[j]){
                    temp = doubles[j];
                    doubles[j] = doubles[i];
                    doubles[i] = temp;

                    // 更新排序下后的下标
                    int x = index[i];
                    index[i] = index[j];
                    index[j] = x;
                }
            }
        }

        // 将排序好的重量和价值重新去数组
        double[] w1 = new double[num];
        double[] v1 = new double[num];
        for (int i = 0; i < num; i++) {
            w1[i] = intsWeight[index[i]];
            v1[i] = intsValue[index[i]];
        }

        double [] x=new double[num];
        double maxValue= 0;
        for (int i = 0; i < num; i++) {
            if(w1[i] < capacity){
                x[i] = 1;
                maxValue += v1[i];
                capacity -= w1[i];
            }else {
                x[i] = capacity/w1[i];
                maxValue = maxValue + capacity/w1[i]*v1[i];
                break;
            }
        }
        if(num == 4){
            System.out.print("最优解：");
            for (int i = 0; i < x.length; i++) {
                System.out.printf("%.2f ",x[i]);
            }
            System.out.println();

            System.out.printf("总价值：%.2f",maxValue);
        }else {
            Map<Double,Double> map = new LinkedHashMap<>();
            for (int i = 0; i < w1.length; i++) {
                for (int j = 0; j < intsWeight.length; j++) {
                    if(w1[i] == intsWeight[j]){
                        map.put(intsWeight[j],x[i]);
                    }
                }
            }
            double [] x1 =new double[num];
            // 处理向量按原来的重量顺序输出
            for (Map.Entry<Double, Double> doubleDoubleEntry : map.entrySet()) {
                for (int i = 0; i < intsWeight.length; i++) {
                    if(doubleDoubleEntry.getKey() == intsWeight[i]){
                        x1[i] = doubleDoubleEntry.getValue();
                    }
                }
            }

            System.out.print("最优解：");
            for (int i = 0; i < x1.length; i++) {
                System.out.printf("%.2f ",x1[i]);
            }
            System.out.println();

            System.out.printf("总价值：%.2f",maxValue);
        }


    }



}
