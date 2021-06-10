package com.eltobeski.Random;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public static String decodeString(String s) {
        return null;
//
//        Deque<Integer> integerDeque = new ArrayDeque<>();
//        Deque<Character> characterDeque = new ArrayDeque<>();
//        int num,i = 0;
//        while (i<s.length()){
//
//        }
    }

//    public static String helper(String s) {
//
//    }

//    public static String getBracketSubString(String s){
//        int open =1;
//        int close = 1;
//
//    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]b]";
        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
    }
}
