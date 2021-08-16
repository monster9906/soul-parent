package com.soul.springbootrocketmq.consumer;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author richfu
 * @date 2021/08/16
 * @description
 */
@Component
public class MessageListenerHandler implements MessageListenerConcurrently {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageListenerHandler.class);
    private static String TOPIC = "DemoTopic";

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        if (CollectionUtils.isEmpty(list)) {
            LOGGER.info("receive blank msgs...");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt messageExt = list.get(0);
        String msg = new String(messageExt.getBody());
        if (messageExt.getTopic().equals(TOPIC)) {
            // mock 消费逻辑
            mockConsume(msg);
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    private void mockConsume(String msg){
        LOGGER.info("receive msg: {}.", msg);
    }
}
