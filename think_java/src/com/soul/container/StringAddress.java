package com.soul.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/5-17:56
 */
public class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString()+ " " +s;
    }
}

class FillList{
    public static void main(String[] args) {
        // 所有的引用都被执行同一地方
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4,new StringAddress("hello")));

        System.out.println(list);

        // 所有对象引用指向同一地方，fill() 替换list中已经填充的数据
        Collections.fill(list,new StringAddress("world"));
        System.out.println(list);
    }
}
