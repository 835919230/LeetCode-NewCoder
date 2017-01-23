package com.sword;

/**
 * Created by hexi on 17-1-20.
 */
public class Duplucate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        duplication[0] = duplicate(numbers, length);
        return duplication[0] != -1;
    }

    public static int duplicate(int numbers[], int length) {
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                return index;
            }
            numbers[index] += length;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}, 7));
    }
}
