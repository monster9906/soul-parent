package com.soul.string;

import javax.lang.model.element.VariableElement;
import java.util.Formatter;

/**
 * @author LingCoder
 * @Description: 格式修饰符打印购物数据
 * @Date 2020/12/12-22:39
 */
public class Receipt {
    private double total = 0;
    private Formatter formatter = new Formatter(System.out);

    public void printTitle(){
        formatter.format("%-15s %5s %10s\n","Item","Qty","Price");
        formatter.format("%-15s %5s %10s\n","----","----","----");
    }

    public void print(String name,int qty,double price){
        formatter.format("%-15.15s %5d %10.0f\n",name,qty,price);
        total += price;
    }

    public void printTotal(){
        formatter.format("%-15s %5s %10.2f\n","Tax","",total *0.06);
        formatter.format("%-15s %5s %10s\n","","","-----");
        formatter.format("%-15ss %5s %10.2f\n","total","",total*1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Magic Beass",4,4.25);
        receipt.print("bears porridge",5,5.1);
        receipt.printTotal();
    }

}
