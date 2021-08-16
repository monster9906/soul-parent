package com.soul.think;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * 测试输入：123（需要找给顾客的钱 n元）
 * 预期输出：
 * 100元 1张
 * 50元 0张
 * 20元 1张
 * 10元 0张
 * 5元 0张
 * 2元 1张
 * 1元 1张
 * @Date 2020/11/9-16:30
 */
public class SmallChange {
    // 存储零钱
    private static int[] money = {100,50,20,10,5,2,1};

    // 存储次数
    private static Map<Integer,Integer> map = new LinkedHashMap<>();


    // 将所有的面值金额put进map
    static{
        for (int i : money) {
            map.put(i,0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        // 判断是否找零成功
        int flag = changeMoney(i, 0);

        if(flag == 1){ // 找零成功
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey()+"元 "+entry.getValue()+"张");
            }
        }else{
            System.out.println("当前输入有误");
        }

    }



    private static int changeMoney(int number,int i){
        int smallMoney = number;
        if(number ==  0){ // 求剩余零钱
            return 0;
        }else {
            for (int j = 0; j < money.length; j++) {
                if(smallMoney >= money[j]){
                    // 更新剩余零钱
                    smallMoney= smallMoney-money[j];
                    Integer integer = map.get(money[j]);
                    integer = integer +1;
                    map.put(money[j],integer);
                    i++;
                    // 继续递归
                    changeMoney(smallMoney,i);
                    break;
                }
            }
            return 1;
        }
    }

}
