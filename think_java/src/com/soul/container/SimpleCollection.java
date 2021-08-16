package com.soul.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/6-12:12
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            c.add(i);
        }

        for (Integer cc : c) {
            System.out.print(cc +", ");
        }
    }
}
