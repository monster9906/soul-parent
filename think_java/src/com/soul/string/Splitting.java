package com.soul.string;

import java.util.Arrays;

/**
 * @author LingCoder
 * @Description:
 * \xhh 十六进制weioxhhh的字符
 * \t 制表符
 * \n 换行符
 * \r 回车
 * \f 换页
 * \e 转义
 * \s 空白符
 * \S 非空白符 【\^s】
 * \d 数字
 * \D 非数字
 * \w 词字符
 * \W 非词字符
 * ^ 一行的开始
 * $ 一行的结束
 * \b 词的边界
 * \B 非词的边界
 * \G 前一个匹配的结束
 * @Date 2020/12/13-17:19
 */
public class Splitting {
    public static String kinghts = "Then,when you have found the shrubbery,you must cut down the minghtiest tree in the forest...";

    public static void split(String regex){

        System.out.println(Arrays.toString(kinghts.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+"); // \W是非单词字符  ，\w 是一个单词
        split("n\\W+");
    }
}
