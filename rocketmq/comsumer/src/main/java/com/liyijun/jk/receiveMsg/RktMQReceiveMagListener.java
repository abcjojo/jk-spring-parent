package com.liyijun.jk.receiveMsg;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Description: 接收来自producer：com.liyijun.jk.sendmsg.ProducerService的消息
 * @author: liyijun
 * @date: 2022年09月08日 14:24
 */

@Service
@RocketMQMessageListener(consumerGroup = "test", topic = "test-topic")
public class RktMQReceiveMagListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        System.out.println("消费者接收到消息：" + msg);
    }
}
