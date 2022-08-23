package com.liyijun.jk.receiveMsg;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 * @author java1234_小锋
 * @site www.java1234.com
 * @company 南通小锋网络科技有限公司
 * @create 2021-08-22 22:40
 */
@RocketMQMessageListener(topic = "java1234-rocketmq",consumerGroup ="${rocketmq.consumer.group}" )
@Component
public class ConsumerService implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("收到消息内容："+s);
    }
}
