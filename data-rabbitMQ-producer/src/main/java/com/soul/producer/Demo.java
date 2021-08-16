package com.soul.producer;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;


/**
 * @author LingCoder
 * @Description: rabbit消息生产者
 * @Date 2020/8/14-11:49
 */
public class Demo {

    private static final String QUEUENAME = "soul";

  public static void main(String[] args)  {
      //定义连接
      Connection connection = null;
      //定义通道
      Channel channel = null;
      try {
          // 创建连接工厂
          ConnectionFactory connectionFactory = new ConnectionFactory();

          // 连接服务器
          connectionFactory.setHost("134.175.192.139");
          // 设置端口
          connectionFactory.setPort(5672);
          // 设置账户密码
          connectionFactory.setUsername("guest");
          connectionFactory.setPassword("guest");

          // 设置默认虚拟机 一个虚拟机相当于一个独立的mq服务
          connectionFactory.setVirtualHost("/");

          // 通过工厂创建连接
          connection = connectionFactory.newConnection();
          // 通过连接创建通道,每个通道代表一个会话任务
          channel = connection.createChannel();
          // 创建队列
          /**
           * param1:队列名称
           *  param2:是否持久化
           * param3:队列是否独占此连接
           * param4:队列不再使用时是否自动删除此队列
           * param5:队列参数
           * @author LingCoder
           * @date 2020/8/14 12:33
           * @param [args]
           * @return void
           */
          channel.queueDeclare(QUEUENAME,true,false,false,null);

          // 定义消息发送内容
          String msg = "Hello,RabbitMQ"+System.currentTimeMillis();

          // 发布消息
          // param1：Exchange的名称，如果没有指定，则使用Default Exchange
          // param2:routingKey,消息的路由Key，是用于Exchange（交换机）将消息转发到指定的消息队列
          // param3:消息包含的属性
          // param4：消息体
          channel.basicPublish("",QUEUENAME,null,msg.getBytes(StandardCharsets.UTF_8));

          System.out.println("消息发送完成："+msg);

      } catch (Exception e) {
          e.printStackTrace();
      } finally{
          // 释放资源
          if(channel != null){
              try {
                  channel.close();
              } catch (IOException e) {
                  e.printStackTrace();
              } catch (TimeoutException e) {
                  e.printStackTrace();
              }
          }
          if(connection != null){
              try {
                  connection.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }

  }
}
