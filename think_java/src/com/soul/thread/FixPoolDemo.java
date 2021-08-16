package com.soul.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author LingCoder
 * @Description: 固定大小线程池
 * @Date 2020/11/16-22:13
 */
public class FixPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            // 创建任务
            Runnable task = new TaskDemo();
            // 加入线程池
            pool.execute(task);
        }
        // 关闭线程池
        pool.shutdown();
    }
}

class cachePoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Runnable task = new TaskDemo();
            pool.execute(task);
        }
        pool.shutdown();
    }
}

class singlePoolDemo{
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            TaskDemo taskDemo = new TaskDemo();
            pool.execute(taskDemo);
        }
        pool.shutdown();
    }
}

class schulePoolDemo{
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            TaskDemo taskDemo = new TaskDemo();
            pool.execute(taskDemo);
        }
        pool.shutdown();
    }

}