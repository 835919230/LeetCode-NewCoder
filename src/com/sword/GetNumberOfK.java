package com.sword;

/**
 * Created by HeXi on 2017/1/19.
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    static class Solution {
        public int GetNumberOfK(int[] array, int k) {
            if (array == null || array.length == 0)
                return 0;
            int c = 0;
            int left = 0;
            int right = array.length - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (array[mid] == k) {
                    c++;
                    int i = mid;
                    //再向右边找
                    while (i + 1 < array.length && array[i + 1] == k) {
                        i++;
                        c++;
                    }
                    i = mid;
                    //再向左边找
                    while ((i - 1) >= 0 && array[i - 1] == k) {
                        i--;
                        c++;
                    }
                    break;
                } else if (array[mid] > k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return c;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.GetNumberOfK(new int[]{1, 2, 2, 2, 3, 4, 5, 6, 7}, 4));

        int i = 0;
        if ((i=i+1)==1 && (i=i+1) != 2)
            System.out.println("yes");
    }
}
