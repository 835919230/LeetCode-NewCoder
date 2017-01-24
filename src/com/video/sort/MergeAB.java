package com.video.sort;

/**
 * Created by hexi on 17-1-23.
 */
public class MergeAB {
    public static int[] mergeAB(int[] A, int[] B, int n, int m) {
        while (m != 0) {
            if (n == 0) {
                A[m - 1] = B[m - 1];
                m--;
            } else {
                A[m + n - 1] = A[n - 1] > B[m - 1] ? A[--n] : B[--m];
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] m = mergeAB(new int[]{1, 3, 5, 0, 0, 0}, new int[]{2, 4, 6}, 3, 3);
        for (int i : m) {
            System.out.println(i);
        }
    }
}
