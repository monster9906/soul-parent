package com.soul.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LingCoder
 * @Description: 使用线程池的方法产生随机整数，并将随机整数添加到队列中
 * @Date 2021/2/3-14:40
 */
public class GenCode {

    public static void main(String[] args) {
        Integer count = 20000;
        long currentTimeMillis = System.currentTimeMillis();

        final List<Integer> lis = new LinkedList<>();

        ThreadPoolExecutor tp = new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(count));

        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    lis.add(random.nextInt());
                }
            });
        }
        tp.shutdown();

        try {
            tp.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - currentTimeMillis);
        System.out.println(lis.size());

    }

}

class GenCode2{
    public static void main(String[] args) {
        Integer count = 20000;
        long currentTimeMillis = System.currentTimeMillis();
        final List<Integer> lis = new LinkedList<>();
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    lis.add(random.nextInt());
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis() - currentTimeMillis);
        System.out.println(lis.size());


    }
}

class Demoe{
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            System.out.println("1111111111111111111");
        } finally {
            reentrantLock.unlock();
        }
    }
}
