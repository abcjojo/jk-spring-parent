package com.liyijun.jk.receiveMsg;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 *      消费 com.liyijun.jk.sendmsg.RocketMQOrderController 中的消息
 *
 *      1、consumerGroup  指定分组组名，一台服务上唯一
 *      2、topic：topic名称
 *      3、ConsumeMode：消费类型：CONCURRENTLY 并发消费； ORDERLY:顺序消费
 *      4、selectorExpression：指定消费tag，默认为*，消费所有tag
 *
 * @author: liyijun
 * @date: 2022年09月08日 16:53
 */

@Service
@RocketMQMessageListener(consumerGroup = "orderly", topic = "orderly-topic", consumeMode = ConsumeMode.ORDERLY, selectorExpression = "tag111")
public class RktMqOrderlyMsgLintener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("顺序消费消息：" + s);
    }
}
