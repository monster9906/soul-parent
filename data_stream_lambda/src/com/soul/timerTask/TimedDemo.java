package com.soul.timerTask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author LingCoder
 * @Description: timer模拟定时任务
 * @Date 2020/8/25-15:47
 */
public class TimedDemo {
  public static void main(String[] args) {

    // 定义一个任务
    TimerTask timerTask =
         new TimerTask(){
            int count = 0;
          @Override
          public void run() {
              count++;
            System.out.printf("第%d次执行：执行时间：%s\n",count,new Date());
          }
        };

    // 计时器
      Timer timer = new Timer();
      timer.schedule(timerTask,1000,3000);

  }
}
