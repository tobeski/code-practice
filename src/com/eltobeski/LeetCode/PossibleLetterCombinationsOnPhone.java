package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PossibleLetterCombinationsOnPhone {
   public static List<String> combinations;

    public static List<String> letterCombinations(String digits) {
        char[][] reps = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        combinations = new ArrayList<>();
        helper(digits,reps,"");
        return combinations;
    }

    public static void helper(String digits, char[][] reps,String created){
        if(digits.length()==0) { combinations.add(created);
        return;}

        int num = Integer.parseInt(digits.substring(0,1));
        char[] possibleChars = reps[num-2];
        for(char a : possibleChars){
            helper(digits.substring(1),reps,created+a);
        }
    }

    public static void main(String[] args){
        letterCombinations("23");
        combinations = combinations;
    }
}
