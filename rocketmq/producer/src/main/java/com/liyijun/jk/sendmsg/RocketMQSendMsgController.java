package com.liyijun.jk.sendmsg;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**    blog地址：https://blog.csdn.net/qq_26383975/article/details/125368252
 *      普通消息的三种发送方式：
 *          1、单向消息：只负责发送消息，不确认发送结果，且没有回调； 优点：发送消息速度最快；
 *              缺点：可能会丢失消息，不可靠；  场景：适合收集日志
 *          2、同步消息：发送消息后等待接收方确认，收到确认后才发送下一条消息； 优点：安全可靠
 *              缺点：三种方式中速度最慢（实际速度快，只是相对其他两种慢）；场景：重要邮件通知、报名短信等
 *          3、异步消息：指发送方发送消息后，不等待接收方回应，接着发送下一条消息，异步接收broker的回调结果，引入了一个countDownLatch来保证
 *              所有回调方法都执行完了在关闭provider； 优点：这种方式可靠，消息不会被丢失，这种方式使用得当，可以提高系统的响应速度，提高用户体验；
 *              场景：用户视频上传后通知启动转码服务
 *      消费消息有两种模式：
 *          1、拉模式：消费者主动去broker上拉消息，根据topic和tag进行过滤，拉消息这种方式有一个偏移量offset：可以自己过滤，也可以不管理，一次默认拉取32条
 *          2、推模式：broker收到消息后，主动推到消费者上，前提是需要消费者注册一个监听器
 *
 *          注意： 消费者只接受broker中的消息，或者通过offset偏移量去啦消息，消息消费过后，消费者不会擅自删除broker中的消息，broker中的消息删除由配置文件配置，
 *              可配置项：消息存储时长，消息删除时间，比如每天凌晨1点，删除超过48h的消息。
 *
 */
@RestController
@RequestMapping("/sendMsg2Mq")
public class RocketMQSendMsgController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/test/{data}")
    public String test(@PathVariable("data") String data) {
        System.out.println("发送普通消息。。。");
        return "okk--" + data;
    }

    // http://localhost:8092/sendMsg2Mq/sendMsg/111
    /** 发送普通消息  */
    @GetMapping("/sendMsg/{data}")
    public void sendMsg(@PathVariable("data") String data) {
        System.out.println("发送普通消息。。。");
        rocketMQTemplate.convertAndSend("test-topic", "普通消息 send message : " + data);
        System.out.println("发送完成");
    }


    /** 发送普通消息  */
    @GetMapping("/sendOneWayMsg/{data}")
    public void sendOneWayMsg(@PathVariable("data") String data) {
        rocketMQTemplate.sendOneWay("test-topic", "单向消息 send one way message : " + data);
    }

    /** 发送同步消息  */
    @GetMapping("/sendSyncMsg/{data}")
    public void sendSyncMsg(@PathVariable("data") String data) {
        //参数一：topic   如果想添加tag,可以使用"topic:tag"的写法
        //参数二：消息内容
        SendResult sendResult = rocketMQTemplate.syncSend("test-topic", "同步消息发送 send sync message : " + data);
        // SendResult [sendStatus=SEND_OK, msgId=7F000001E55818B4AAC2275E594E0005, offsetMsgId=C0A8007900002A9F00000000000027CC,
        //              messageQueue=MessageQueue [topic=test-topic, brokerName=DESKTOP-457FLQP, queueId=2], queueOffset=1]
        System.out.println(sendResult);
    }

    // http://localhost:8092/sendMsg2Mq/sendAsyncMsg/444
    /** 发送异步消息  */
    @GetMapping("/sendAsyncMsg/{data}")
    public void sendAsyncMsg(@PathVariable("data") String data) {

        // 参数1：topic名称，如果想添加tag，使用topic:tag 这种写法
        // 参数2：消息内容
        // 参数3：回调
        rocketMQTemplate.asyncSend("test-topic", "异步消息发送 send one way message : " + data, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                //SendResult [sendStatus=SEND_OK, msgId=7F000001E55818B4AAC2275E9F330008, offsetMsgId=C0A8007900002A9F0000000000002C33,
                //              messageQueue=MessageQueue [topic=test-topic, brokerName=DESKTOP-457FLQP, queueId=3], queueOffset=0]
                System.out.println(sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("消息发送异常！");
                throwable.printStackTrace();
            }
        });
    }

}
