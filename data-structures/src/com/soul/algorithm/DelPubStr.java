package com.soul.algorithm;

import com.sun.deploy.security.ruleset.BlockRule;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description: 输入两个字符串,
 * 从第一个字符串中删除第二个字符串中的所有字符。
 * 例如输入”They are students.”和”aeiou”,
 * 则,删除之后的第一个字符串变成”Thy r stdnts.”
 * @Date 2020/9/14-21:08
 */
public class DelPubStr {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("请输入字符串1：");
      String s1 = scanner.nextLine();
      Scanner scanner2 = new Scanner(System.in);
      System.out.println("请输入字符串2：");
      String s2 = scanner2.nextLine();
      String s = delStr(s1, s2);
      System.out.println("最后结果："+s);
  }


  /**
   * @author LingCoder
   * @date 2020/9/15 15:41
   * @description: 从字符串1中删除字符串2
   * @return java.lang.String
   */
  private static String  delStr(String str1 ,String str2){
      // 第一个字符串
      char[] chars = str1.toCharArray();
      char[] chars2 = str2.toCharArray();
      String s = new String();


      for (int i = 0; i < chars.length; i++) {
          boolean flag = true;

          for (int j = 0; j < chars2.length; j++) {
              if(chars[i] == chars2[j]){
                flag = false;
            }
          }

          if(flag){
              s += chars[i];
          }


      }
      return s;
  }

}
