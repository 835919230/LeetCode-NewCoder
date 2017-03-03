package com.jdk;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hexi on 17-2-20.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    new Thread(new Worker()).start();
                }
            }
        }).start();
        System.out.println("等待CountDownLatch...");
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("新建线程的count结束");
            }
        }).start();
        System.out.println("CountDownLatch结束...");
    }

    static final int count = 4;
    static final CountDownLatch cdl = new CountDownLatch(count);

    static class Worker implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread()+" count down");
            cdl.countDown();
        }
    }
}
