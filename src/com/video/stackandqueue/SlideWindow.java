package com.video.stackandqueue;

import java.util.LinkedList;

/**
 * Created by hexi on 17-1-30.
 */
public class SlideWindow {
    public int[] slide(int[] arr, int n, int w) {
        if (arr == null || w < 1 || n < w)
            return null;
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[n - w + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i])
                qmax.pollLast();
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlideWindow sw = new SlideWindow();
        int[] slide = sw.slide(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 8, 3);
        for (int i : slide) {
            System.out.println(i);
        }
    }
}
