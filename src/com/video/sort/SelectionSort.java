package com.video.sort;

/**
 * Created by hexi on 17-1-22.
 */
public class SelectionSort {
    public static int[] selectionSort(int[] A, int n) {
        int[] a = A;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < min && a[j] < a[i]) {
                    min = a[j];
                    idx = j;
                }
            }
            swap(a, i, idx);
        }
        return a;
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = selectionSort(new int[]{3, 1, 5, 2, 1, 4, 5, 7}, 8);
        for (int a : array) {
            System.out.println(a);
        }
    }
}
