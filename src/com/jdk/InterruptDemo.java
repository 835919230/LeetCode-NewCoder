package com.jdk;

/**
 * Created by hexi on 17-2-14.
 */
public class InterruptDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new Task());
        t.start();
        t.interrupt();
        System.out.println(t.isInterrupted());
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println("finish task...");
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }
}
