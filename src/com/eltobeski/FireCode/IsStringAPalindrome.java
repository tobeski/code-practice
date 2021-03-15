package com.eltobeski.FireCode;

public class IsStringAPalindrome {
    public static boolean isStringPalindrome(String str){
        if(str==null)
            return true;
        int length = str.length();
        for(int i = 0; i< length/2;i++)
            if(str.charAt(i)!=str.charAt(length-i-1)){
                return false;
            }
        return true;

    }
}
