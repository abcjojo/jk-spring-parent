package com.liyijun.jk.mq.print0_100;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 使用多线程交替打印0-100
 */
class PrintThread1 {
    public static int num = 1;

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
        synchronized (PrintThread1.class) {
            while (true) {
                try {
                    PrintThread1.class.notify();
                    if (num <= 100) {
                        if (Thread.currentThread().getName().equals("线程一")) {
                            if (num % 2 == 0) {
                                System.out.println(Thread.currentThread().getName() + "->" + num++);
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + "->" + num++);
                        }
                    }
                    PrintThread1.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}