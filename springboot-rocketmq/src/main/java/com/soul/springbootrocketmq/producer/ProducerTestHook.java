package com.soul.springbootrocketmq.producer;

import org.apache.rocketmq.client.hook.SendMessageContext;
import org.apache.rocketmq.client.hook.SendMessageHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author richfu
 * @date 2021/08/16
 * @description
 */
public class ProducerTestHook implements SendMessageHook {
    public static final Logger LOGGER = LoggerFactory.getLogger(ProducerTestHook.class);
    @Override
    public String hookName() {
        return ProducerTestHook.class.getName();
    }

    @Override
    public void sendMessageBefore(SendMessageContext sendMessageContext) {
        LOGGER.info("执行发送消息之前：{}",sendMessageContext);
    }

    @Override
    public void sendMessageAfter(SendMessageContext sendMessageContext) {
        LOGGER.info("执行发送消息之后：{}",sendMessageContext);
    }
}
