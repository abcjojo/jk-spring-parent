package com.liyijun.jk.mq.blockingqueue;

import java.util.concurrent.LinkedBlockingDeque;

/**
*   使用阻塞队列 实现生产者-消费者模型
*/
public class MainTest {
    public static void main(String[] args) {
        LinkedBlockingDeque strings = new LinkedBlockingDeque(4);
        new Product(strings).start();
        new Consumer(strings).start();
        new Consumer(strings).start();
        new Consumer(strings).start();
    }
}