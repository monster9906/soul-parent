package com.soul.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LingCoder
 * @Description:
 * @Date 2021/2/3-16:32
 */
public class Counter {
    private Integer counter = 0;
    public int increase(){
        synchronized (this){
            counter += 1;
            return counter;
        }
    }
    public int decrease(){
        counter -= 1;
        return counter;
    }

    public Integer getCounter() {
        return counter;
    }
}
class Counter2{
    private AtomicInteger counter = new AtomicInteger();
    public int increase(){
        return counter.incrementAndGet();
    }
    public int decrease(){
        return counter.decrementAndGet();
    }

    public AtomicInteger getCounter() {
        return counter;
    }
}

class Demo{
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        Counter counter = new Counter();
        for (int i = 0; i < 200; i++) {
            ThreadPoolExecutor tp = new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    counter.increase();
                }
            });
            tp.shutdown();

            try {
                tp.awaitTermination(1,TimeUnit.DAYS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
        System.out.println(counter.getCounter());

        long currentTimeMillis1 = System.currentTimeMillis();
        Counter2 counter2 = new Counter2();
        for (int i = 0; i < 200; i++) {
            ThreadPoolExecutor tp = new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    counter2.increase();
                }
            });
            tp.shutdown();

            try {
                tp.awaitTermination(1,TimeUnit.DAYS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis1);
        System.out.println(counter2.getCounter());

    }
}
