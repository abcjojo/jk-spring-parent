package com.liyijun.jk.mq.thread;

import java.util.Vector;


public class Producer implements Runnable {
    private Goods goods;
    private Object lock;
    private Vector container;

    Producer(Object lock, Vector container) {
        this.lock = lock;
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                goods = new Goods(1, "商品");
                if (container.size() < 5) {
                    container.add(goods);
                    System.out.println(Thread.currentThread().getName() + "生产商品");
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}