package com.soul.container;

import java.util.*;

/**
 * @author LingCoder
 * @Description: 对类型产生最好的假设
 * @Date 2020/11/6-12:30
 */
class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusvy extends Snow{}
class Slush extends Snow{}

public class AsListInference {

    public static void main(String[] args) {
        List<Snow> snows = Arrays.asList(new Crusvy(), new Slush(), new Powder());
        System.out.println(snows);

        List<Snow> snows1 = Arrays.asList(new Light(), new Heavy());
        System.out.println(snows1);

        List<Snow> snows2 = new ArrayList<>();
        Collections.addAll(snows2,new Light(),new Heavy());
        System.out.println(snows2);

        List<Snow> snows3 = Arrays.<Snow>asList(new Light(),new Heavy());
        System.out.println(snows3);
    }
}
