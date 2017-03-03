package com.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hexi on 17-2-12.
 */
public class threadpool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Task t = new Task();
        for (int i = 0; i < 20; i++) {
            es.submit(t);
        }
        es.shutdown();
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("thread start...");
//            }
//        };
//        if (!thread.isInterrupted())
//            thread.interrupt();
//
//        int i = Integer.SIZE - 3;
//        System.out.println(((i << i) - 1) & 23);

//        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
//
//        try {
//            Integer poll = queue.take();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    static class Task implements Runnable {
        private AtomicInteger c = new AtomicInteger(1);

        @Override
        public void run() {
            System.out.println((c.getAndIncrement()) + " " + Thread.currentThread().getName());
        }
    }
}
