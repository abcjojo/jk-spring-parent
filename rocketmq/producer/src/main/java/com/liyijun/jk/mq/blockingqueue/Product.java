package com.liyijun.jk.mq.blockingqueue;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Product extends Thread {

    private LinkedBlockingDeque stringLinkedBlockingDeque;

    Product(LinkedBlockingDeque stringLinkedBlockingDeque) {
        this.stringLinkedBlockingDeque = stringLinkedBlockingDeque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int nextInt = new Random().nextInt(5000);
            System.out.println("product sleep ：" + nextInt);
            try {
                stringLinkedBlockingDeque.put("物品" + i);
                System.out.println("生产者生产:" + i);
                sleep(nextInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}