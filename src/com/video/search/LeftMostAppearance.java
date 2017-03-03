package com.video.search;

/**
 * Created by hexi on 17-1-30.
 */
public class LeftMostAppearance {
    public final static int findPos(int[] arr, int n, int num) {
        if (arr == null || arr.length <= 0 || n <= 0)
            return -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num > arr[mid]) {
                left = mid + 1;
            } else if (num < arr[mid]) {
                right = mid - 1;
            } else {
                int pos;
                for (pos = mid;
                     pos >= 0 && arr[pos] == num;
                     pos--);
                return pos + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPos(new int[]{1, 2, 3, 3, 4}, 5, 3));
        System.out.println(findPos(new int[]{36, 62, 146, 208, 210, 369, 616}, 7, 6160));
        System.out.println(findPos(new int[]{67, 447, 594}, 3, 67));
    }
}
