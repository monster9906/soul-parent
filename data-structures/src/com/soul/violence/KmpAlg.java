package com.soul.violence;

import java.util.Arrays;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/9/15-14:58
 */
public class KmpAlg {
  public static void main(String[] args) {
    String str1 = "BBC ABCDAB ABCDABCDABDE";
    String str2 = "ABCDABD";
    int[] ints = kmpNext(str2);

    System.out.println(kmpSearch(str1, str2, ints));
  }

  /**
   * @author LingCoder
   * @date 2020/9/15 15:30
   * @description: 查找到对应的元素出现的首个索引
   * @return int
   */
  private static int kmpSearch(String str1,String str2 ,int[] ints){
    for (int i = 0,j =0; i < str1.length(); i++) {

       while (j>0 && str1.charAt(i) != str2.charAt(j)){
           j = ints[j-1];
       }

        if(str1.charAt(i) == str2.charAt(j)){
            j++;
        }

       if(j==str2.length()){
           return i-j+1;
       }
    }
      return -1;
  }


  /**
   * @author LingCoder
   * @date 2020/9/15 15:00
   * @description: 获取字串的部分匹配串
   * @return int[]
   */
  private static int[] kmpNext(String string){
        int[] next = new int[string.length()];
        // 字符串第一个是默认为0
         next[0] = 0;

        for (int i = 1,j=0; i < string.length(); i++) {

            // string.charAt(i) != string.charAt(j) 重置j
            while (j>0 && string.charAt(i) != string.charAt(j)){
                j = next[j-1];
            }

            if(string.charAt(i) == string.charAt(j)){
                j++;
            }
            next[i] = j;
        }
      return next;
  }
}
