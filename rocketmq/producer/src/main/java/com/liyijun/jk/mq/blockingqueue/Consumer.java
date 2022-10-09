package com.liyijun.jk.mq.blockingqueue;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Consumer extends Thread {

    private LinkedBlockingDeque stringLinkedBlockingDeque;

    Consumer(LinkedBlockingDeque stringLinkedBlockingDeque) {
        this.stringLinkedBlockingDeque = stringLinkedBlockingDeque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int nextInt = new Random().nextInt(10000);
            try {
                String take = (String) stringLinkedBlockingDeque.take();
                System.out.println(Thread.currentThread() + ":消费者消费：" + take + ":nextInt:" + nextInt);
                sleep(nextInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}