package com.jdk.ds;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hexi on 17-2-22.
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1001, "David");
        map.put(1002, "Simon");
        map.put(1003, "Sam");
        map.put(1004, "Lily");
        Thread.yield();

        System.out.println(map.get(1001));
        int len = 16;
        for (int i = 1001; i < 1001 + len - 4; i++) {
            int hash = spread(new Integer(i).hashCode());
            System.out.println(((len - 1) & hash));
        }
//        System.out.println(0x7fffffff);
//        System.out.println(Integer.MAX_VALUE);
    }

    static final int spread(int h) {
        return (h ^ (h >>> 16)) & Integer.MAX_VALUE;
    }

    static class TestForSomething {
        public static void main(String[] args) {
            int i;
            outer: for (i=0;;) {
                if (i == 100)
                    break outer;
                if (i % 5 == 0) {
                    System.out.println(i++);
                    continue outer;
                }
                i++;
            }
        }
    }
}
