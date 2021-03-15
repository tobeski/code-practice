package com.eltobeski.LeetCode;


import java.util.HashSet;
import java.util.Set;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int stringLength = s.length();
        int length = 0;
        for (int i = stringLength-1; i>=0;i--){
            if(s.charAt(i)!=' ') length++;
            else break;
        }
        return length;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("How far "));
        System.out.println(lengthOfLastWord("YAwwwwww d d"));
        Set<String> uniqueCodes = new HashSet<>();

    }
}
