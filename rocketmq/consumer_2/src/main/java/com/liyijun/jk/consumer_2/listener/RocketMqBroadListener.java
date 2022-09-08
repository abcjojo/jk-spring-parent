package com.liyijun.jk.consumer_2.listener;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 *      消息生产者：com.liyijun.jk.sendmsg.RocketMQBroadController
 *
 *      1、messageModel：消息类型
 *          BROADCASTING：广播模式    同一消费者组内的每个消费者，只消费到Topic的一部分消息，所有消费者消费的消息加起来就是Topic的所有消息
 *          CLUSTERING：集群模式      同一消费者组内的每个消费者，都消费到Topic的所有消息。如Topic有100条消息，则同个消费者组下的所有消费者都能消费到100条消息。
 *
 * @author: liyijun
 * @date: 2022年09月08日 17:58
 */

@Service
@RocketMQMessageListener(consumerGroup = "broad", topic = "broad-topic", messageModel = MessageModel.CLUSTERING)
public class RocketMqBroadListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("集群模式 消费者222，消费消息："+s);
    }

}
