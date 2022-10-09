package com.liyijun.jk.mq.thread;

import java.util.Vector;

public class Consumer implements Runnable {
    private Goods goods;
    private Object lock;
    private Vector container;

    Consumer(Object lock, Vector container) {
        this.lock = lock;
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                if (!container.isEmpty()) {
                    container.remove(0);
                    System.out.println(Thread.currentThread().getName() + "消费商品");
                } else {
                    lock.notifyAll();
                }
            }
        }
    }
}