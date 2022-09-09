package com.liyijun.jk.receiveMsg;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 *      消费 com.liyijun.jk.sendmsg.RocketMQDelayController 中的消息
 *
 * @author: liyijun
 * @date: 2022年09月08日 16:53
 */

@Service
@RocketMQMessageListener(consumerGroup = "delay", topic = "delay-topic")
public class RktMqDelayMsgLintener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("延时消费消息：" + s);
    }
}
