package com.liyijun.jk.sendmsg;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: liyijun
 * @date: 2022年09月08日 17:50
 */

@RestController
public class RocketMQBroadController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/broadMsg")
    public String broadMsg() {
        for (int i = 0; i < 10; i++) {
            rocketMQTemplate.convertAndSend("broad-topic", "message---" + i);
        }
        return "okk---1212";
    }
}
