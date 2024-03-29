package com.video.sort;

/**
 * Created by HeXi on 2017/1/19.
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int random = left + (int) (Math.random() * (right - left + 1));
        swap(arr, random, right);
        int mid = partition(arr, left, right);
        process(arr, left, mid - 1);
        process(arr, mid + 1, right);
    }

    /**
     * 把小于中枢值的元素放于中枢值之前，这里的遍历先让中枢值在最前面，循环结束之后再把这个中枢值和区间里最后一个小于它的元素交换
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right) {
        int pivot = left - 1;
        int index = left;
        while (index <= right) {
            if (arr[index] <= arr[right]) {
                swap(arr, ++pivot, index);
            }
            index++;
        }
        return pivot;
    }

    private static void swap(int[] arr, int random, int right) {
        int tmp = arr[random];
        arr[random] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] ints = {3, 1, 5, 3, 7, 2, 8, 4, 23, 1};
        quickSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+(i == ints.length - 1 ? "\n":" "));
        }
    }
}
