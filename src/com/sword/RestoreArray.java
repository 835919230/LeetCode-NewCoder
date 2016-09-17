package com.sword;

/**
 * Created by 诚 on 2016/9/10.
 */
public class RestoreArray {
    public static void reOrderArray(int [] array) {
        if (array == null || array.length <= 0)
            return;
        for (int i = 0; i < array.length - 1; i++) {
            int head = array[i];
            int j = i + 1;
            if (!isEven(array[j])) {
                int tmp = array[j];
                while (j >= 1 && isEven(array[j-1]) ) {
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = tmp;
            }
        }
    }

    private static boolean isEven(int x){
        return ((x & 1)==0);
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        reOrderArray(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
}
