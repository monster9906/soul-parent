package com.soul.springbootrocketmq.consumer;

import org.apache.rocketmq.client.hook.ConsumeMessageContext;
import org.apache.rocketmq.client.hook.ConsumeMessageHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author richfu
 * @date 2021/08/16
 * @description
 */
public class ConsumerTestHook implements ConsumeMessageHook {
    public static final Logger LOGGER = LoggerFactory.getLogger(ConsumerTestHook.class);
    @Override
    public String hookName() {
        return ConsumerTestHook.class.getName();
    }

    @Override
    public void consumeMessageBefore(ConsumeMessageContext consumeMessageContext) {
        LOGGER.info("消费发送之前：{}",consumeMessageContext);
    }

    @Override
    public void consumeMessageAfter(ConsumeMessageContext consumeMessageContext) {
        LOGGER.info("消费发送之后：{}",consumeMessageContext);
    }
}
