package com.soul.violence;

/**
 * @author LingCoder
 * @Description: 暴力匹配算法
 * @Date 2020/9/15-13:24
 */
public class ViolenceMath {

  public static void main(String[] args) {
        String str1 = "asdfghjj";
        String str2 = "sd";
        int match = match(str1, str2);
    System.out.println(match);
  }

  private static int match(String str1 ,String str2){
      char[] chars1 = str1.toCharArray();
      char[] chars2 = str2.toCharArray();

      int len1 = chars1.length;
      int len2 = chars2.length;

      int i = 0;// 索引指向chars1
      int j = 0; // 索引指向chars2
      while (i<len1 && j<len2){
          // 匹配成功
          if(chars1[i] == chars2[j]){
              // 指针后移
               i++;
               j++;

          }else{// 匹配失败,第一个字符串指针后移
              i = i-(j-1);
              j = 0;
          }
      }
      // 返回匹配成功出索引
      if(j==len2){
          return i-j;
      }else {
          return -1;
      }
  }
}
