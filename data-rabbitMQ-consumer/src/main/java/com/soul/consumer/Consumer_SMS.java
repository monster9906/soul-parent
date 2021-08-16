package com.soul.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/8/14-14:48
 */
public class Consumer_SMS {
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    // 交换机名称
    private static final String EXCHANGE_FANOUT_INFORM = "exchange_fanout_inform";

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
          // 创建通道
          Channel channel = connection.createChannel();

          // 通道声明交换机
          channel.exchangeDeclare(EXCHANGE_FANOUT_INFORM, BuiltinExchangeType.FANOUT);
          //声明队列
          channel.queueDeclare(QUEUE_INFORM_SMS,true,false,false,null);
          // 交换机与队列绑定
          channel.queueBind(QUEUE_INFORM_SMS,EXCHANGE_FANOUT_INFORM,"");

          // 创建消费方法
          DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
              @Override
              public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                  long deliveryTag = envelope.getDeliveryTag();
                  String exchange = envelope.getExchange();
                  //消息内容
                  String message = new String(body, StandardCharsets.UTF_8);
                  System.out.println(message);
              }
          };
          channel.basicConsume(QUEUE_INFORM_SMS,defaultConsumer);


      } catch (IOException e) {
          e.printStackTrace();
      } catch (TimeoutException e) {
          e.printStackTrace();
      } finally {
      }
  }
}
