package com.soul.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author Rich_fu
 * @date 2021/3/10
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        final Exchanger<List<Integer>> exchanger = new Exchanger<>();

        new Thread(){
            @Override
            public void run() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                try {
                     list = exchanger.exchange(list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1"+list);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                List<Integer> list = new ArrayList<>();
                list.add(4);
                list.add(5);
                try {
                    list = exchanger.exchange(list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2"+list);
            }
        }.start();
    }

}
