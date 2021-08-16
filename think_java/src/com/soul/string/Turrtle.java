package com.soul.string;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/12/12-22:29
 */
public class Turrtle {
    private String name;
    private Formatter formatter;
    public Turrtle(String name,Formatter formatter){
        this.name = name;
        this.formatter = formatter;
    }

    public void move(int x,int y){
        formatter.format("%s the turrtle is at (%d,%d)\n",name,x,y);
    }

    public static void main(String[] args) {
        PrintStream out = System.out;
        Turrtle tom = new Turrtle("tom", new Formatter(System.out));
        Turrtle jack = new Turrtle("jack", new Formatter(out));

        jack.move(0,0);
        tom.move(5,4);
        jack.move(7,0);
        tom.move(8,6);
    }
}
