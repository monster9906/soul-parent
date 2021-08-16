package com.soul.timerTask;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/8/25-16:04
 */
public class ScheduledExecutorServiceDemo {
  public static void main(String[] args) {
    // 创建任务队列
      ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

    scheduledExecutorService.scheduleAtFixedRate(
        () -> {
          System.out.println("执行时间："+new Date());
        },
        1,
        3,
        TimeUnit.SECONDS);
  }
}
