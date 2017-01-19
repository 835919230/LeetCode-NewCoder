package com.sword;

/**
 * Created by HeXi on 2017/1/19.
 */
public class ReverseSentence {
    public static String reverseSentence(String str) {
        if (str == null || "".equals(str))
            return "";
        if (str.length() != 0 && str.trim().length() == 0)
            return str;
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]).append(i == 0 ? "" : " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = reverseSentence("I am a student.");
        System.out.println(s);

        String example = "    aa";
        String[] split = example.split(" ");
        System.out.println(split.length);
        System.out.println(example.trim().length());
    }
}
