package com.liyijun.jk;

import com.liyijun.jk.sendmsg.ProducerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 *  rocketmq消息demo学习blog：https://blog.csdn.net/qq_26383975/article/details/125368252
 *  rocketmq windows本地启动blog: https://blog.csdn.net/qq_64872360/article/details/126432287
 *
 *   rocketmq 本地服务启动:
 *      进入安装目录bin目录
 *      启动nameserver ： start mqnamesrv.cmd
 *      启动broker : start mqbroker.cmd -n 127.0.0.1:9876 autoCreateTopicEnable=true
 *
 *   rocketmq可视化界面启动： 目录 D:\develop\rocketmq-all-4.2.0-bin-release\rocketmq-externals-master\rocketmq-externals-master\rocketmq-console\target
 *                        启动命令： java -jar rocketmq-console-ng-1.0.0.jar
 *                        访问地址：127.0.0.1:18080  端口根据配置文件走，默认为8080
*/

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext run = SpringApplication.run(ProducerApplication.class, args);
//        ProducerService producerService = (ProducerService) run.getBean("producerService");
//        producerService.sendMessage();

        SpringApplication.run(ProducerApplication.class, args);
    }

}
