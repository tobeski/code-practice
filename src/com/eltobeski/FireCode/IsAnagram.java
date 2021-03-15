package com.eltobeski.FireCode;

public class IsAnagram {
    public static boolean isAnagram(String input1, String input2) {
        if(input1==null || input2==null || input1.isEmpty() || input2.isEmpty())
            return false;
        if(input1.length()!=input2.length())
            return false;
        int[] counters = new int[256];
        for(int i=0;i<input1.length();i++){
            int s1pointer = input1.charAt(i);
            int s2pointer = input2.charAt(i);
            counters[s1pointer]++;
            counters[s2pointer]--;
        }

        for(int i=0;i<counters.length;i++){
            if(counters[i]!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println(isAnagram("def","fed"));

    }
}
