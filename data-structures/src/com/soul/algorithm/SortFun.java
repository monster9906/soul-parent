package com.soul.algorithm;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.security.util.Length;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author LingCoder
 * @Description:输入的第1行为字符串的个数n(n<=100),
 * 接下来的n行,每行一个字符串,字符串长度都小于100,均由小写字母组成.
 * 如果这些字符串是根据字典序排列而不是根据长度排列,输出”is lexicalorder”;
 * 如果这些字符串是根据长度排列而不是根据字典序排列,输出”lengths”;如果良种方式都符合,输出”both”, 否则,输出”none”
 * @Date 2020/9/14-17:36
 */
public class SortFun {
  private static final  String  ISEXICALORDER =  "is exicalorder";
  private static final  String  LENGTHS =  "lengths";
  private static final  String  BOTH =  "both";
  private static final  String  NONE =  "none";

  public static void main(String[] args) {
    int num = 0;
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入字符串的个数：");
    num = scanner.nextInt();
    String[] strings = new String[num];
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < num; i++) {
      String s = sc.nextLine();
      strings[i] = s;
    }

    // 是否是长度排序
    boolean lengthOrder = LengthOrder(strings);

    // 是否是字典排序
    boolean lexicographicSorting = LexicographicSorting(strings);

    if(lengthOrder && lexicographicSorting){
      System.out.println(BOTH);
    }else if(lengthOrder){
      System.out.println(LENGTHS);
    }else if(lexicographicSorting){
      System.out.println(ISEXICALORDER);
    }else {
      System.out.println(NONE);
    }


    //System.out.println(b);
  }

  /**
   * @author LingCoder
   * @date 2020/9/14 17:40
   * @description: 字典序排序
   * @return boolean
   */
  private static boolean LexicographicSorting(String[] strings){
      boolean flag = true;

      for (int i = 1;i<strings.length;i++) {
        char[] chars = strings[i-1].toCharArray();
        char[] chars2 = strings[i].toCharArray();
        if(i == strings.length){
          break;
        }

        int len = chars.length;
        for (int j = 0; j < len; j++) {
          if(j==chars.length){
            flag =  false;
            break;
          }
          if(chars[j] > chars2[j]){
            flag = false;
            break;
          }else if(chars[j]<chars2[j]){
            flag = true;
            break;
          }
          if(chars[j]== chars2[j]){
            len = chars2.length;
            break;
          }

        }

      }

      return flag;
  }

  /**
   * @author LingCoder
   * @date 2020/9/14 17:53
   * @description: 长度序排序
   * @return java.lang.String[]
   */
  private static boolean LengthOrder(String[] strings){
    boolean flag = false;
    for (int i = 0; i < strings.length; i++) {
      for (int j = 1; j < strings.length-1; j++) {
        if(strings[i].length() >= strings[j].length()){
          flag = true;
        }else{
          flag = false;
        }
      }
    }
     return flag;
  }

}
