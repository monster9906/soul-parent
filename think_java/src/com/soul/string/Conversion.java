package com.soul.string;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/12/12-22:56
 */
public class Conversion {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);
        char u = 'a';
        System.out.println(" u = 'a'");
        formatter.format("s:%s\n",u);
        formatter.format("c:%c\n",u);
        formatter.format("b:%b\n",u);
        formatter.format("h:%h\n",u);

        System.out.println("------------------------------");

        int v = 121;
        System.out.println("v = 121");
        formatter.format("d: %d\n",v);
        formatter.format("c: %c\n",v);
        formatter.format("b: %b\n",v);
        formatter.format("s: %s\n",v);

        System.out.println("------------------------------");
        BigInteger w = new BigInteger("500000000000000");
        System.out.println(" w = new BigInteger(\"500000000000000\")");
        formatter.format("d: %d\n",w);
        //formatter.format("c: %c\n",w);
        formatter.format("b: %b\n",w);
        formatter.format("s: %s\n",w);
        formatter.format("x: %x\n",w);
        formatter.format("h: %h\n",w);




    }
}
