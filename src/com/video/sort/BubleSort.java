package com.video.sort;

/**
 * Created by hexi on 17-1-22.
 */
public class BubleSort {
    public static int[] bubbleSort(int[] A, int n) {
        int[] a = A;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j])
                   swap(a, i, j);
            }
        }

        return a;
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = bubbleSort(new int[]{3, 1, 5, 2, 1, 4, 5, 7}, 8);
        for (int a : array) {
            System.out.println(a);
        }
    }
}
