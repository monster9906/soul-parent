package com.soul.exception;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/16-16:57
 */
public class Switch {
    private boolean state = false;
    public boolean read(){return state;}
    public void on(){
        state =true;
        System.out.println(this);
    }

    public void off(){
        state = false;
        System.out.println(this);
    }

    public String toString(){return state?"on":"off";}

}

class OnOffException1 extends  Exception{}

class OnOffException2 extends  Exception{}

class OnOffSwith{
    private static Switch sw = new Switch();
    public static void f() throws OnOffException1,OnOffException2{}

    public static void main(String[] args) {
        try {
            sw.on();
            f();
            sw.off();
        } catch (OnOffException1 onOffException1) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 onOffException2) {
            System.out.println("OnOffException2");
            sw.off();
        }finally {
            sw.off();
        }
    }
}
