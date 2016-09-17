package com.sword;

import java.util.Arrays;

/**
 * Created by 诚 on 2016/9/10.
 */
public class TwoDimensionSearch {
    public static boolean find(int[][] array,int target) {
        if (array.length <= 0 || array[0].length <= 0)
            return false;
        for (int i = 0; i < array.length; i++) {
            int rel = Arrays.binarySearch(array[i], target);
            if (rel >= 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6}};
        System.out.println(find(a,5));
        System.out.println(find(a,1));
        System.out.println(find(a,19));
    }
}
