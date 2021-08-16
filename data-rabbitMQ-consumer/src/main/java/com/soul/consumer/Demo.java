package com.soul.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author LingCoder
 * @Description: 消息消费者
 * @Date 2020/8/14-12:40
 */
public class Demo {
    private static final String QUEUENAME = "soul";

  public static void main(String[] args) throws IOException, TimeoutException {
      ConnectionFactory connectionFactory = new ConnectionFactory();
      // 连接服务器
      connectionFactory.setHost("134.175.192.139");
      // 设置端口
      connectionFactory.setPort(5672);
      // 设置账户密码
      connectionFactory.setUsername("guest");
      connectionFactory.setPassword("guest");
      Connection connection = connectionFactory.newConnection();
      Channel channel = connection.createChannel();

      // 声明队列
      channel.queueDeclare(QUEUENAME,true,false,false,null);
    // 定义消费方法
    Consumer consumer =
        new DefaultConsumer(channel) {
          @Override
          public void handleDelivery(
              String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
              throws IOException {
            System.out.println("-------------------------------------------");
            System.out.println("consumerTag : " + consumerTag);
            System.out.println("exchangeName : " + envelope.getExchange());
            System.out.println("routingKey : " + envelope.getRoutingKey());
            String msg = new String(body, StandardCharsets.UTF_8);
            System.out.println("消息内容 : " + msg);

            // 消息确认
            channel.basicAck(envelope.getDeliveryTag(), false);
            System.out.println("消息确认完成！");
          }
        };
     channel.basicConsume(QUEUENAME,consumer);


  }
}
