package com.video.sort;

/**
 * Created by hexi on 17-1-23.
 */
public class ShellSort {
    public int[] shellSort(int[] arr, int n) {
        shellSort(arr);
        return arr;
    }

    public void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        int feet = arr.length / 2;
        int index = 0;
        while (feet > 0) {
            for (int i = feet; i < arr.length; i++) {
                index = i;
                while (index >= feet) {
                    if (arr[index - feet] > arr[index]) {
                        swap(arr, index - feet, index);
                        index -= feet;
                    } else break;
                }
            }
            feet /= 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        ShellSort s = new ShellSort();
        int[] array = new int[0];
        try {
            array = s.shellSort(new int[]{6, 5, 3, 1, 8, 7, 2, 4}, 8);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("fail");
            return;
        } finally {
            System.out.println("finally");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
