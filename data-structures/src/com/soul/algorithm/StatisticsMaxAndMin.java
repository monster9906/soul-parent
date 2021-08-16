package com.soul.algorithm;

import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Random;

/**
 * @author LingCoder
 * @Description:编写一个实验程序，随机产生10个1~20的整数，
 * 设计一个高效算法，找其中的最大元素和最小元素，
 * 并统计元素之间的比较次数。调用该算法执行10次，并求元素的平均比较次数
 * @Date 2020/9/14-16:44
 */
public class StatisticsMaxAndMin {
    // 比较次数
    private static  int count = 0;

  public static void main(String[] args) {
      int sum = 0;

    for (int i = 0; i < 10; i++) {

      int[] ints = generateNum();
      sortPop(ints);
      System.out.printf("第%d组: %s: 最大值:%d  最小值:%d 比较次数：%d \n",i+1,Arrays.toString(ints),ints[0],ints[9],count);
      sum+=count;
      // 使次数复原
      count=0;
    }
    System.out.println("平均比较次数："+sum/10);
 }

  /**
   * @author LingCoder
   * @date 2020/9/14 16:54
   * @description: 随机生成1-20的数字
   * @return int[]
   */
  private static int[] generateNum(){
      int[] arr = new int[10];

      Random random = new Random();
    for (int i = 0; i < arr.length; i++) {
        int num = random.nextInt(20) + 1;
        arr[i]= num;
    }

    return arr;
  }


  /**
   * @author LingCoder
   * @date 2020/9/14 17:03
   * @description:  将一个数组里面的数据从大到小依次排列
   *  这里用冒泡排序
   * @return void
   */
  private static int[] sortPop(int[] arr){
      //避免空指针
      if(arr != null && arr.length >0){
          for (int i = 0; i < arr.length; i++) { //  //取出数组中的第一个值
            for (int j = 0; j < arr.length-1; j++) { // 取出数组中第二个值
                //在第一次循环中比较两个值的大小，
                // 如果第一个值大于第二个值，则将两个值互换，
                // 否则接着用第一个值和下一次循环的值进行比较
                if(arr[i]>arr[j]){
                    count++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
          }
      }

      return arr;
  }
}
