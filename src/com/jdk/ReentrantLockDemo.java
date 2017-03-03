package com.jdk;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hexi on 17-2-13.
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Task task = new Task();
        for (int i = 0; i < 100; i++) {
            es.execute(task);
        }
        es.shutdown();
    }

    static class Singleton {
        private Singleton() {
            throw new RuntimeException("");
        }

        private static Singleton INSTANCE = null;

        public static Singleton getInstance() {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    synchronized (Singleton.class) {
                        INSTANCE = new Singleton();
                    }
                }
            }
            return INSTANCE;
        }
    }

    static final ReentrantLock lock = new ReentrantLock(true);

    static class Task implements Runnable {
        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread());
            System.out.println(lock.getQueueLength());
            lock.unlock();
        }
    }

    static class LongTaskCheck {
        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) {
                new Thread(new LongTask()).start();
            }
        }

        static final ReentrantLock lock = new ReentrantLock(true);

        static class LongTask implements Runnable {
            @Override
            public void run() {
                lock.lock();

                try {
                    Thread.currentThread().sleep(1000_000_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }
}