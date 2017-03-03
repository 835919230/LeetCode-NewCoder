package com.jdk;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by hexi on 17-2-15.
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
//        int num = 10;
        int num = 2;
        CyclicBarrier cb = new CyclicBarrier(num);
//        for (int i = 0; i < num; i++) {
//            Thread t = new Thread(new Task(cb, i + 1));
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            t.start();
//        }
        Thread t = new Thread(new Task(cb, 1));
        t.start();

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t1 = new Thread(new Task(cb, 2));
        t1.start();
    }

    static class Task implements Runnable {
        private final CyclicBarrier cb;
        private final int id;

        Task(CyclicBarrier cb, int id) {
            this.cb = cb;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("Task#" + id + " is waiting...");
                cb.await();
                System.out.println("Task#" + id + " is finished...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
