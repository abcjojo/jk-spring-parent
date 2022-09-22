package com.liyijun.jk.mq.thread;

import java.util.Vector;

/**
    线程协作方式 实现生产者-消费者模型
*/
public class MainTest {
    public static void main(String[] args) {
        Vector goods = new Vector(5);
        Object lock = new Object();
        Producer producer = new Producer(lock, goods);
        Consumer consumer = new Consumer(lock, goods);
        for (int i = 0; i < 5; i++) {
            Thread threadA = new Thread(producer, "生产者线程" + i);
            threadA.start();
        }
        for (int j = 0; j < 3; j++) {
            Thread threadB = new Thread(consumer, "消费者线程" + j);
            threadB.start();
        }
    }
}