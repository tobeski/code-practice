package com.eltobeski.FireCode;


//Also the answer for Anagram
public class IsPermutation {
    public static boolean permutation(String input1, String input2) {
        if(input1==null || input2==null || input1.isEmpty() || input2.isEmpty())
            return false;
        if(input1.length()!=input2.length())
            return false;
        int[] counters = new int[256];
        for(int i=0;i<input1.length();i++){
            int s1pointer = input1.charAt(i);
            int s2pointer = input2.charAt(i);
            counters[s2pointer]--;
            counters[s1pointer]++;
        }

        for(int i=0;i<counters.length;i++){
            if(counters[i]!=0)
                return false;
        }
        return true;
    }


}
