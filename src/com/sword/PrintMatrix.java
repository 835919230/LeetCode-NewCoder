package com.sword;

import java.util.ArrayList;

/**
 * Created by HeXi on 2017/1/17.
 * @link https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 输入一个矩阵，
 * 按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 *          1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字
 *          1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    static class Solution {
        public ArrayList<Integer> printMatrix(int[][] matrix) {
            int rowCount = matrix.length;
            int colCount = matrix[0].length;
            ArrayList<Integer> list = new ArrayList<>(rowCount * colCount);
            if (rowCount == 0 || colCount == 0)
                return list;
            int top = 0, bottom = rowCount - 1, left = 0, right = colCount - 1;
            while (top <= bottom && left <= right) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                for (int i = top+1; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                //如果只有一行或者一列下面不用打印
                if (top != bottom)
                    for (int i = right-1; i >= left ; i--) {
                        list.add(matrix[bottom][i]);
                    }
                if (left != right)
                    for (int i = bottom-1; i >= top+1; i--) {
                        list.add(matrix[i][left]);
                    }
                top++;bottom--;left++;right--;
            }
            return list;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> list = new Solution().printMatrix(matrix);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
