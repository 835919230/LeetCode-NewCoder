package com.jdk;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by hexi on 17-2-13.
 */
public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = Thread.currentThread();
                LockSupport.park(this);
                System.out.println(Thread.interrupted());
                System.out.println("Inside...");
            }
        });
        thread.start();
        spin();
        System.out.println("b");
        System.out.println(thread.isAlive());
        LockSupport.unpark(thread);
    }
    static void spin() {
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) <= 5000L);
    }



    static class UnReentrant {
        public static void main(String[] args) {
            LockSupport.park(new Thread());
        }
    }
}
