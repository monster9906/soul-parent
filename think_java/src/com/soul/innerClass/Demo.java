package com.soul.innerClass;

/**
 * @author LingCoder
 * @date 2020/7/27 10:37
 */
public class Demo {
    public Wrapping wrapping(int x){
        return new Wrapping(x){
            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }
    public static void main(String[] args) {
        Demo p = new Demo();
        Wrapping w = p.wrapping(10);
    }

}
