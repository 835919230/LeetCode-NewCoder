package com.jdk;

import java.util.concurrent.*;

/**
 * Created by hexi on 17-2-21.
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> ft = new FutureTask<>(() -> {
            Thread.sleep(3000L);
            return 1 + 1;
        });
        Thread t = new Thread(ft);
        t.start();
        System.out.println("wait...");
        Integer rel = ft.get();
        System.out.println(rel);
    }
}
