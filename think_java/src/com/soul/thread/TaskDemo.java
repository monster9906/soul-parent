package com.soul.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/16-22:11
 */
public class TaskDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" running successful");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
