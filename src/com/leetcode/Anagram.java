package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 诚 on 2016/9/7.
 * @see @link https://leetcode.com/problems/valid-anagram/
 */
public class Anagram {
    public boolean isAnagram(String s,String t) {
        Map<Character,Integer> map1 = createMap(s);
        Map<Character,Integer> map2 = createMap(t);
        return map1.equals(map2);
    }

    public Map<Character,Integer> createMap(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c))
                map.put(c,new Integer(1));
            else
                map.replace(c, map.get(c)+1);
        }
        return map;
    }

    /**
     * Beautiful solution
     * @param s
     * @param t
     * @return
     */
    public boolean isAna(String s, String t) {
        char[] sc = s.toCharArray();
        char[] st = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(st);
        return Arrays.equals(sc,st);
    }

    public static void main(String[] args) {
        String s = "anagram",t="nagaram";
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAna(s,t));
        System.out.println(anagram.isAna("rat","car"));
        System.out.println(anagram.isAna("",""));
    }
}
