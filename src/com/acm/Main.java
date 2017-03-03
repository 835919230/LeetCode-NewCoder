package com.acm;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
//        map.put(1003, "hexo");
//        map.put(1001, "835919230");
//        map.put(1002, "admin");
//        Set<Map.Entry<Integer, String>> entries = map.entrySet();
//        for (Map.Entry<Integer, String> entry : entries) {
//            System.out.println(entry.getKey()+","+entry.getValue());
//        }
//        String regex = "\\w(\\d\\d)(\\w+)";
//        String candidate = "x99SuperJava";
//
//        Pattern p = Pattern.compile(regex);
//        Matcher matcher = p.matcher(candidate);
//        if(matcher.find()){
//            int gc = matcher.groupCount();
//            for(int i = 0; i <= gc; i++)
//                System.out.println("group " + i + " :" + matcher.group(i));
//        }
//        test2();
        test3();
    }

    public static void test2() {
        //create a Matcher and use the Matcher.start() method
        String candidateString = "My name is Bond. James Bond.";
        String matchHelper[] =
                {"          ^","                      ^"};
        Pattern p = Pattern.compile("Bond");
        Matcher matcher = p.matcher(candidateString);

        //Find the starting point of the first 'Bond'
        matcher.find();
        int startIndex = matcher.start();
        System.out.println(candidateString);
        System.out.println(matchHelper[0] + startIndex);

        //Find the starting point of the second 'Bond'
        matcher.find();
        int nextIndex = matcher.start();
        System.out.println(candidateString);
        System.out.println(matchHelper[1] + nextIndex);
    }

    public static void test3(){
        //create a Pattern
        Pattern p = Pattern.compile("B(ond)");

        //create a Matcher and use the Matcher.group(int) method
        String candidateString = "My name is Bond. James Bond.";
        //create a helpful index for the sake of output
        Matcher matcher = p.matcher(candidateString);
        //Find group number 0 of the first find
        matcher.find();
        String group_0 = matcher.group(0);
        String group_1 = matcher.group(1);
        System.out.println("Group 0 " + group_0);
        System.out.println("Group 1 " + group_1);
        System.out.println(candidateString);

        //Find group number 1 of the second find
        matcher.find();
        group_0 = matcher.group(0);
        group_1 = matcher.group(1);
        System.out.println("Group 0 " + group_0);
        System.out.println("Group 1 " + group_1);
        System.out.println(candidateString);
    }
}
