package com.soul.innerClass;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/10/30-15:35
 */
public class Triangle {
    // 等腰
    public static final int ISOSCELES = 1;

    // 等边
    public static final int EQUILATERAL = 2;

    // 一般
    public static final  int GENERAL = 3;

    // 不是三角形
    public static final int NOTHING = 4;
    double a,b,c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static int isWhichOne(Triangle triangle){
        double a = triangle.a;
        double b = triangle.b;
        double c = triangle.c;

        if(a<1 || a>200){
           return Triangle.NOTHING;
        }
        if(b<1 || b>200){
            return Triangle.NOTHING;
        }
        if(c<1 || c>200){
            return Triangle.NOTHING;
        }

        if(a+b > c && a+c > b && b+c > a && Math.abs(a-b) <c && Math.abs(a-c) < b && Math.abs(b-c) < a){
            if(a== b && a==c && b == c){
                return Triangle.EQUILATERAL;
            }else if(a == b || a==c || b == c){
                    return Triangle.ISOSCELES;
            } else{
                return Triangle.GENERAL;
            }
        }else{
            return Triangle.NOTHING;
        }
    }

    public static void translate(Triangle triangle){
        int type = isWhichOne(triangle);
        switch (type) {
            case Triangle.ISOSCELES:
                System.out.println("等腰三角形");
                break;
            case Triangle.GENERAL:
                System.out.println("一般三角形");
                break;
            case Triangle.EQUILATERAL:
                System.out.println("等边三角形");
                break;
            default:
                System.out.println("不构成三角形");
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("输入构成三角形的三边长：(空格隔开)\n退出按 (n/N), 否则继续: ");
        String error="输入有误，请重新输入: ";

        String reg = "^\\d+\\s+\\d+\\s+\\d+$";

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine().trim();
            if("n".equalsIgnoreCase(line)){
                break;
            }
            if(! line.matches(reg)){
                System.err.println(error);
            }else {
                String[] split = line.split("\\s+");
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                Triangle triangle = new Triangle(a, b, c);
                translate(triangle);
            }
            System.out.println("按(n/N),退出，否则继续");
        }
        scanner.close();
    }


}
