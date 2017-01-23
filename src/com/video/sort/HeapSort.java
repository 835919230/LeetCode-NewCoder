package com.video.sort;

/**
 * Created by hexi on 17-1-23.
 */
public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        for (int i = n / 2; i >= 0; i--) {
            heapAdjust(A, i, n);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(A, 0, i);
            heapAdjust(A, 0, i);
        }

        return A;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void heapAdjust(int[] A, int index, int length) {
        int temp = A[index];
        for (int j = 2 * index + 1; j < length; j = j * 2 + 1) {
            if (j < length - 1 && A[j] < A[j + 1]) j++;
            if (temp > A[j]) break;
            A[index] = A[j];
            index = j;
        }
        A[index] = temp;
    }

    public static void main(String[] args) {
        HeapSort h = new HeapSort();
        int[] array = {3, 1, 5, 2, 1, 4, 5, 7};
        h.heapSort(array, array.length);
        for (int anArray : array) System.out.println(anArray);
    }
}
