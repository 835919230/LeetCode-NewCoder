package com.sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by HeXi on 2017/1/18.
 * 找出最小的K个数
 * 未完成，应使用堆排序
 */
public class LeastKNumbers {
    static class Solution {
        // TODO: 2017/1/18 使用堆排序
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            if (input.length < k)
                return list;
            Arrays.sort(input);
            for (int i = 0; i < k; i++) {
                list.add(input[i]);
            }

            return list;
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(7);
        Integer peek = priorityQueue.peek();
        System.out.println(peek);

        int size = priorityQueue.size();

        for (int i = 0; i < size; i++) {
            System.out.println(priorityQueue.poll());
        }
    }
}
