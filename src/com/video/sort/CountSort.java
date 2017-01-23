package com.video.sort;

/**
 * Created by hexi on 17-1-23.
 */
public class CountSort {
    public static int[] countingSort(int[] arr, int n) {
        if (arr == null || arr.length <= 0)
            return arr;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        int[] help = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i] - min]++;
        }
        for (int i = min, j = 0; i < max + 1; i++) {
            while (help[i - min]-- > 0)
                arr[j++] = i;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = countingSort(new int[]{54,35,48,36,27,12,44,44,8,14,26,17,28}, 13);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
