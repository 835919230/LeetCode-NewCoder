package com.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 取交集的写法，双指针写法
 */
public class No349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int left = 0, right = 0;

        List<Integer> list = new ArrayList<>();
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] < nums2[right]) {
                left++;
            } else if (nums1[left] > nums2[right]) {
                right++;
            } else {
                int val = nums1[left];
                list.add(val);
                while (left < nums1.length && nums1[left] == val) {
                    left++;
                }
                while (right < nums2.length && nums2[right] == val) {
                    right++;
                }
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        No349 obj = new No349();
        print(obj.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4}));
        print(obj.intersection(new int[]{2,1}, new int[]{1,2}));
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
