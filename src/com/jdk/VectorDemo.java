package com.jdk;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hexi on 17-2-25.
 */
public class VectorDemo {
    static final AtomicInteger ai = new AtomicInteger(0);
    public static void main(String[] args) {
        final Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 100000; i++) {
            final int j = i;
            new Thread(() -> vector.add(j)).start();
        }

        Collections.sort(vector);
        System.out.println(isSorted(vector));
        System.out.println(vector.size());
        System.out.println(vector);
    }

    private static boolean isSorted(List<Integer> list) {
        if (list == null)
            return false;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + 1 != list.get(i + 1))
                return false;
        }
        return true;
    }
}
