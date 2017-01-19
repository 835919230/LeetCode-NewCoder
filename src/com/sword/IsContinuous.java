package com.sword;

/**
 * Created by HeXi on 2017/1/19.
 */
public class IsContinuous {
    public static boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < 0 || number > 13) return false;
            if (number == 0) continue;
            if (((flag >> number) & 1) == 1) return false;
            flag |= (1 << number);
            if (number > max) max = number;
            if (number < min) min = number;
            if (max - min >= 5) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{1, 2, 3, 4, 5}));
    }
}
