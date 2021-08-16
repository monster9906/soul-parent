package com.soul.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/8/14-15:12
 */
public class Producer_routing {
    // 队列名称
    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String QUEUE_INFORM_SMS = "queue_iform_sms";

    // 交换机名称
    private static final String EXCHANGE_ROUTING_INFORM = "exchange_routing_inform";

  public static void main(String[] args) {
      try {
          ConnectionFactory connectionFactory = new ConnectionFactory();
          connectionFactory.setHost("134.175.192.139");
          connectionFactory.setPort(5672);
          connectionFactory.setUsername("guest");
          connectionFactory.setPassword("guest");
          connectionFactory.setVirtualHost("/");

          // 创建连接
          Connection connection = connectionFactory.newConnection();
          // 创建会话通道
          Channel channel = connection.createChannel();

          // 声明交换机
          channel.exchangeDeclare(EXCHANGE_ROUTING_INFORM, BuiltinExchangeType.DIRECT);

          // 声明队列
          channel.queueDeclare(QUEUE_INFORM_EMAIL,true,false,false,null);
          channel.queueDeclare(QUEUE_INFORM_SMS,true,false,false,null);

          // 队列与交换机绑定
          channel.queueBind(QUEUE_INFORM_SMS,EXCHANGE_ROUTING_INFORM,QUEUE_INFORM_SMS);
          channel.queueBind(QUEUE_INFORM_EMAIL,EXCHANGE_ROUTING_INFORM,QUEUE_INFORM_EMAIL);

      // 发送消息
      for (int i = 0; i < 10; i++ ){
          String message = "email inform to user"+i;

      }

      } catch (IOException e) {
          e.printStackTrace();
      } catch (TimeoutException e) {
          e.printStackTrace();
      } finally {
      }
  }
}
