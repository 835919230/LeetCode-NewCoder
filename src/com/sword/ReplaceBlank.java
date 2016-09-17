package com.sword;

/**
 * Created by 诚 on 2016/9/10.
 */
public class ReplaceBlank {
    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return "";
        String s = str.toString();
        return s.replaceAll("\\ ","%20");
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(new ReplaceBlank().replaceSpace(str));
    }
}
