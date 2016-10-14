package com.other;

/**
 * Created by hexi on 16-10-14.
 * 问题描述：一个无序数组里有若干个正整数，范围从1到100，其中98个整数都出现了偶数次，只有两个整数出现了奇数次（
 *          比如1,1,2,2,3,4,5,5），如何找到这个出现奇数次的整数？
 */
public class findReplicate {
    public static void main(String[] args) {
        int a[] = new int[100];
        int b = 1;
        for (int i = 0; i < 100; i++) {
            a[i] = b;
            if ((i & 1)==1) b++;
        }
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]+" ");
//        }
        a[94] = 57;
        a[95] = 99;
        int tmp = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            tmp = tmp ^ a[i];
        }
        int tmp2 = 0;
        int tmp3 = 0;
            //如果是偶数，说明两个数最后一位不同
        int condition = tmp & 1;
        if (condition == 0)
            return;
        // TODO: 16-10-15 现在这个解法有问题 只能支持一个是偶数一个是奇数的情况
        int reverseCondition = condition == 1 ? condition - 1 : condition + 1;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 1) == condition)
                tmp2 ^= a[i];
            else if ((a[i] & 1) == reverseCondition)
                tmp3 ^= a[i];
        }
        System.out.println(tmp2);
        System.out.println(tmp3);
    }
}
