package com.acm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeXi on 2017/3/3.
 */
public class Divide {

    public static void main(String[] args) {
        boolean re = resolve(new int[]{2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7});
        System.out.println(re);
        System.out.println(resolve(new int[]{10, 2, 11, 13, 1, 1, 1, 1, 1}));
    }

    /**
     * 整体思路是 左右分别开始累加求和 当左边小时左边下标右移，右边小时右边下标左移
     * <p>
     * 值到左右相等时，取中间部分在对其做一次如上的左右求和对比过程看能否找到中间的平衡点
     * <p>
     * 记得要效验 平衡点的和与之前的和是否相等
     *
     * @param a
     * @return
     */

    private static boolean resolve(int[] a) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        int i = 0;
        int j = a.length - 1;
        int left = a[i];
        int right = a[j];

        while (i < j) {
            if (left < right) {
                i++;
                left += a[i];
            } else if (left > right) {
                j--;
                right += a[j];
            } else if (left == right) {
                leftList.add(i);
                rightList.add(j);
                sumList.add(left);
                i++;
                left += a[i];
            }
        }
        for (int k = 0; k < leftList.size(); k++) {
            if (checkMiddle(leftList.get(k) + 1, rightList.get(k) - 1, sumList.get(k), a))
                return true;
        }
        return false;
    }
    private static boolean checkMiddle(int start, int end, int sum, int[] a) {
        int i = start + 1;
        int j = end - 1;
        int left = a[i];
        int right = a[j];
        while (j > i) {
            if (left < right) {
                i++;
                left += a[i];
            } else if (left > right) {
                j--;
                right += a[j];
            } else if (left == right) {
                if (j - i == 2 && left == sum) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
