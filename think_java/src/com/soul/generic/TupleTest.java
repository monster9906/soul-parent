package com.soul.generic;

/**
 * @author Rich_fu
 * @date 2021/3/13
 */
class Amphhibian{}
class Vehicle{}

public class TupleTest {
  static TwoTuple<String,Integer> f(){
      return new TwoTuple<>("jack",66);
  }

    public static void main(String[] args) {
        TwoTuple<String, Integer> f = f();
        System.out.println(f);
    }

}
