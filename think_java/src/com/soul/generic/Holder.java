package com.soul.generic;

/**
 * @author Rich_fu
 * @date 2021/3/13
 */
class AutoMobile{

}


public class Holder<T> {
    private T a;

    public Holder(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder<AutoMobile> autoMobileHolder = new Holder<>(new AutoMobile());
        AutoMobile a = autoMobileHolder.getA();
        System.out.println(a);

    }

}
