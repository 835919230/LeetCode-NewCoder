package com.leetcode;

import java.util.Arrays;

public class No881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                right--;
                count++;
            } else {
                right--;
                left++;
                count++;
            }
        }
        return count;
    }
}
