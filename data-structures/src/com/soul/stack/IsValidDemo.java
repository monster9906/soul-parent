package com.soul.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/10/18-20:42
 */
public class IsValidDemo {
    public static void main(String[] args) {
        boolean valid = isValid("{[（)]}");
        System.out.println(valid);
    }

    /**
     * @author LingCoder
     * @date 2020/10/18 20:43
     * @description: 判断输入的括号字符串是否有效
     * @return boolean
     */
    public static boolean isValid(String s){
        // 获取括号的长度
        int length = s.length();

        // 判断括号是否成对出现
        if(length % 2 != 0){
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');


        // 定义栈 存取括号，辅助比较
        Stack<Character> stack = new Stack<>();

        // 遍历所有的字符串
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)){ // 合法则入栈
                // 栈为空或括号不匹配,返回
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                // 栈顶出栈
                stack.pop();
            }else {
                // 入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
