package com.liyijun.jk.sendmsg;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *    blog： https://blog.csdn.net/qq_26383975/article/details/125375049
 *    顺序消息：FIFO 按照顺序进行发布和消费的消息类型，顺序消息分为：同步、异步、单向消息
 *         1、syncSendOrderly:发送同步顺序消息（一般使用发送同步顺序消息）
 *         2、asyncSendOrderly： 发送异步顺序消息
 *         3、sendOneWayOrderly：发送单向顺讯消息
 *
 *
 * @author: liyijun
 * @date: 2022年09月08日 15:46
 */

@RestController
public class RocketMQOrderController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/orderMsg")
    public String orderMsg() {

        // 参数1： topic   参数二： 消息内容   参数三： hashKey，一般用来计算决定消息发送到哪个消息队列，一般是订单id这种唯一标识
        rocketMQTemplate.syncSendOrderly("orderly-topic:tag111", "111111创建", "111111");
        rocketMQTemplate.syncSendOrderly("orderly-topic:tag111", "111111支付", "111111");
        rocketMQTemplate.syncSendOrderly("orderly-topic:tag111", "111111完成", "111111");

        rocketMQTemplate.syncSendOrderly("orderly-topic:tag222", "222222创建", "222222");
        rocketMQTemplate.syncSendOrderly("orderly-topic:tag222", "222222支付", "222222");
        rocketMQTemplate.syncSendOrderly("orderly-topic:tag222", "222222完成", "222222");

        return "ok--111";
    }
}
