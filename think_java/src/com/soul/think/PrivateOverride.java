package com.soul.think;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/10/7-20:32
 */
public class PrivateOverride {
    private void f(){
        System.out.println("pirivate f()。。。");
    }

    public static void main(String[] args) {
        PrivateOverride privateOverride = new Derived();
        privateOverride.f();
    }
}

class Derived extends PrivateOverride{
    public void f(){
        System.out.println("public f()...");
    }
}