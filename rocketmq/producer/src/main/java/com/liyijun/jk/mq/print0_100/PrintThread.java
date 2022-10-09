package com.liyijun.jk.mq.print0_100;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: 爱唠嗑的阿磊 * @Company: Java编程之道 * @Date: 2020/7/11 15:06 * PACKAGE_NAME * @Description:
 */
public class PrintThread {
    public static int num = 1;
    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Thread1 thread1 = new Thread1();
        thread1.setName("线程一");
        Thread2 thread2 = new Thread2();
        thread2.setName("线程二");
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.shutdown();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            print();
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            print();
        }
    }

    static void print() {
        reentrantLock.lock();
        synchronized (PrintThread.class) {
            while (true) {
                try {
                    condition.signal();
                    if (num <= 100) {
                        if (Thread.currentThread().getName().equals("线程一")) {
                            if (num % 2 == 0) {
                                System.out.println(Thread.currentThread().getName() + "->" + num++);
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + "->" + num++);
                        }
                    }
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reentrantLock.unlock();
        }
    }
}