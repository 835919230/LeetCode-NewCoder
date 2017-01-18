package com.sword;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by HeXi on 2017/1/18.
 */
public class FullPermutaion {
    static class Solution {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> list = new ArrayList<>();
            if (str == null || "".equals(str) || str.length() == 0)
                return list;

            Permutaion(list, str, 0);
            Collections.sort(list);
            return list;
        }

        private void Permutaion(ArrayList<String> list, String str, int begin) {
            if (begin == str.length() - 1)
                list.add(str);
            for (int i = begin; i < str.length(); i++) {
                if (i != begin && str.charAt(i)==str.charAt(begin))
                    continue;
                swap(str.charAt(i), str.charAt(begin));
                Permutaion(list, str, begin+1);
                swap(str.charAt(i), str.charAt(begin));
            }
        }

        private void swap(char c1, char c2) {
            char tmp = c1;
            c1 = c2;
            c2 = tmp;
        }
    }
}
