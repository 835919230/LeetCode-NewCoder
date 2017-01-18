package com.sword;

/**
 * Created by HeXi on 2017/1/17.
 * BST的后序序列的合法序列是，
 * 对于一个序列S，
 * 最后一个元素是x （也就是根），
 * 如果去掉最后一个元素的序列为T，
 * 那么T满足：T可以分成两段，前一段（左子树）小于x，
 * 后一段（右子树）大于x，
 * 且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
 */
public class LegalBSTSequence {
    static class Solution {
        public boolean VerifySquenceOfBST(int[] sequence) {
            if (sequence == null || sequence.length <= 0)
                return false;
            return judge(sequence, 0, sequence.length - 1);
        }

        private boolean judge(int[] sequence, int left, int right) {
            int l = left, r = right;
            if (l >= r)
                return true;
            int val = sequence[r];
            int i = r - 1;
            //do the partition
            while (i >= l && sequence[i] > val) i--;
            for (int j = i; j >= l; j--) {
                if (sequence[j] > val) return false;
            }
            return judge(sequence, l, i) && judge(sequence, i + 1, r - 1);
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            boolean b = solution.VerifySquenceOfBST(new int[]{4, 8, 6, 12, 16, 14, 10});
            System.out.println(b);
            System.out.println(solution.VerifySquenceOfBST(new int[]{5,4,3,2,1}));
        }
    }
}
