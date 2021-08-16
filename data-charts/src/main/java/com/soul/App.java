package com.soul;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入a:");
        int a = scanner.nextInt();
        System.out.print("请输入b:");
        int b = scanner.nextInt();
        System.out.print("请输入c:");
        int c = scanner.nextInt();

        int[] data = new int[]{a,b,c};

        if(a<1 || a>200){
            System.out.println("不能构成三角形");
        }
        if(b<1 || b>200){
            System.out.println("不能构成三角形");
        }
        if(c<1 || c>200){
            System.out.println("不能构成三角形");
        }

            


    }
}
