package com.video.sort;

/**
 * Created by hexi on 17-1-22.
 */
public class InsertionSort {
    public static int[] insertionSort(int[] a, int n) {
        return insertionSort(a, n, 1);
    }

    public static int[] insertionSort(int[] a, int n, int step) {
        for (int i = 1; i < n; i++) {
            int j = i;
            int t = a[i];
            while (j > 0 && t < a[j - 1]) {
                a[j] = a[j - 1];
                j -= step;
            }
            a[j] = t;
        }

        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = insertionSort(new int[]{6, 5, 3, 1, 8, 7, 2, 4}, 8);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
