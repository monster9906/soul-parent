package com.soul.exception;

/**
 * @author LingCoder
 * @Description:  异常创建在堆上 GC自动回收
 * error exception runtionexception提供了带cause的参数 用来保存原始的异常信息
 * @Date 2020/11/15-14:51
 */
public class WhoCalled {
    static void f(){
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                System.out.println(stackTraceElement);
            }
        }
    }
    static void g(){f();}
    static void h(){f();}

    public static void main(String[] args) {
        f();
        System.out.println("---------------------");
        g();
        System.out.println("---------------------");
        h();
    }
}
