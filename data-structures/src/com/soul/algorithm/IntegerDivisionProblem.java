package com.soul.algorithm;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:整数划分问题
 * 将正整数n表示成一系列正整数之和：n=n1+n2+…+nk，
 * 其中n1≥n2≥…≥nk≥1，k≥1。
 * 正整数n的这种表示称为正整数n的划分。求正整数n的不同划分个数。
 * @Date 2020/10/8-11:09
 */
public class IntegerDivisionProblem {
    // 统计次数时只需考虑n或者m=1或者是n==m时，对应的划分次数+1
    static Integer count =0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入对对应的整数：");
        int i = scanner.nextInt();
        division(i,i,"");
        System.out.println("整数N:"+i+" 有"+count+"种划分方法");
    }

    private static int  division(int m,int n ,String str){
        if(m<=0 || n<=0){
            return 0;
        }
        if(m == 1 || n == 1){ //但递归到这里的时候，输出末尾为1
            System.out.print(str);
            for (int i = 1; i < m; i++) {
                System.out.print("1+");
            }
            System.out.println("1");
            count++;
            return 1;
        }
        if(n == m){
            System.out.println(str+m);
            count++;
            return  1+division(m,n-1,str);
        }
        if(m>n){// n不断减小，知道满足m=1或是n=1的时候返回最后的数1
            int n1 = division(m-n,n,str+n+"+");
            int n2 = division(m,n-1,str);
            return n1 +n2;
        }

        return division(m,m,str);
    }

}
