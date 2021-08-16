package com.soul.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;


/**
 * @author LingCoder
 * @Description: 用户通知，当用户充值成功或转账完成系统通知用户，通知方式有短信、邮件多种方法
 * @Date 2020/8/14-14:11
 */
public class Producer_publish {

    // 队列名称
    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    // 交换机名称
    private static final String EXCHANGE_FANOUT_INFORM = "exchange_fanout_inform";

  public static void main(String[] args) {
      Connection connection = null;
      Channel channel = null;
      try {
          ConnectionFactory connectionFactory = new ConnectionFactory();
          connectionFactory.setHost("134.175.192.139");
          connectionFactory.setPort(5672);
          connectionFactory.setUsername("guest");
          connectionFactory.setPassword("guest");
          connectionFactory.setVirtualHost("/");
          // 创建连接
          connection = connectionFactory.newConnection();
          // 创建会话通道
          channel = connection.createChannel();

          // 声明交换机
          /**
           *
           * @author LingCoder
           * @date 2020/8/14 14:25
           * @param [args] 1.交换机名称 2.交换机类型fanout、topic、direct、headers
           * @return void
           */
          channel.exchangeDeclare(EXCHANGE_FANOUT_INFORM, BuiltinExchangeType.FANOUT);

          // 声明队列
          // 邮件队列
          channel.queueDeclare(QUEUE_INFORM_EMAIL,true,false,false,null);
          // 短信队列
          channel.queueDeclare(QUEUE_INFORM_SMS,true,false,false,null);

          // 交换机与队列绑定
          /**
           *
           * @author LingCoder
           * @date 2020/8/14 14:29
           * @param [args] 1.队列名称，2.交换机名称，3.路由key
           * @return void
           */
          channel.queueBind(QUEUE_INFORM_EMAIL,EXCHANGE_FANOUT_INFORM,"");
          channel.queueBind(QUEUE_INFORM_SMS,EXCHANGE_FANOUT_INFORM,"");

      // 发送消息
      for (int i = 0; i < 10; i++) {
          String msg = "这里是消息发送次数："+i;

          // 发送交换机消息
          channel.basicPublish(EXCHANGE_FANOUT_INFORM,"",null,msg.getBytes(StandardCharsets.UTF_8));
          System.out.println("消息发送完成:"+msg);
      }

      } catch (IOException e) {
          e.printStackTrace();
      } catch (TimeoutException e) {
          e.printStackTrace();
      } finally {
          if(channel!=null){
              try {
                  channel.close();
              } catch (IOException e) {
                  e.printStackTrace();
              } catch (TimeoutException e) {
                  e.printStackTrace();
              }
          }
          if(connection!=null){
              try {
                  connection.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }


  }
}
