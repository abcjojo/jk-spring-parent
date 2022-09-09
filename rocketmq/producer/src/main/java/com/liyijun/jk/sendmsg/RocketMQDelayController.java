package com.liyijun.jk.sendmsg;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 *
 *   rocketMq支持定时的延时消息，但是不支持任意的时间，仅支持定制的18级，例如定时 5s， 10s， 1m 等。
 *   level=0 级表示不延时，level=1 表示 1 级延时，level=2 表示 2 级延时，以此类推。
 *
 *
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

        // 参数1：topic
        // 参数2：Message<T>
        // 参数3：发送消息超时时间
        // 参数4：delayLevel 延时level  messageDelayLevel=1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
        rocketMQTemplate.syncSend("delay-topic", MessageBuilder.withPayload(JSONObject.toJSONString(map)).build(), 3000, 3);

        return "okk---12133";
    }
}
    