package com.jdk;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hexi on 17-2-14.
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            Thread t = new Thread(new Task());
//            t.start();
//        }
        ThreadLocal<Integer> tl = new ThreadLocal<>();
        tl.set(1);
        ThreadLocal<String> tlStr = new ThreadLocal<>();
        tlStr.set("hello");
        tlStr.remove();
        System.out.println("ThreadLocal value: " + tl.get());
    }

    static class Task implements Runnable {

        private final ThreadLocal<Integer> tl = new ThreadLocal<>();

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                tl.set(i);
            }
            System.out.println("ThreadLocal value: " + tl.get());
        }

        public static void main(String[] args) {
            final int delta = 0x61c88647;
            int len = 16;
            final AtomicInteger nextHashCode = new AtomicInteger();
            int hash = nextHashCode.getAndAdd(delta);
            System.out.println(hash);
//            int[] help = new int[len];
//            for (int k = 0; k < len; k++) {
//                ++help[(hash & (len - 1))];
//            }
//            for (int i = 0; i < help.length; i++) {
//                System.out.println(i+": "+help[i]);
//            }
        }
    }
}
