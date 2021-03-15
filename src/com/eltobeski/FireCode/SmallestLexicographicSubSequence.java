package com.eltobeski.FireCode;

import java.util.TreeSet;

public class SmallestLexicographicSubSequence {
    public String smallestSubsequence(String text) {
        TreeSet<Character> test = new TreeSet<>();
        char[] textChar = text.toCharArray();
for (char c
        :textChar
        )  {
    test.add(c);
        }

        return test.toString();

    }

    public static void main(String[] args){
       String test = "leetcode";
        System.out.println(-1%2);
//        transposeMatrix(array);
//        System.out.println(array);
    }
}
