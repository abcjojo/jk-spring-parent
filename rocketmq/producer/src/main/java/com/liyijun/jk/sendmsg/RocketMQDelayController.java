package com.liyijun.jk.sendmsg;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Description:
 * @author: liyijun
 * @date: 2022年09月08日 17:50
 */

@RestController
public class RocketMQDelayController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/delayMsg")
    public String delayMsg() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("orderNumber", "110119110");
        map.put("userName", 2310);
        rocketMQTemplate.syncSend("delay-topic", )


        return "okk---1212";
    }
}
    