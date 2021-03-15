package com.eltobeski.FireCode;

import java.util.LinkedList;
import java.util.Stack;

public class IsNumberAPalindrome {
    public static Boolean isIntPalindrome(int x) {
        int num = x;
        //reversing number
        int reverse=0,remainder;
        while(num > 0)
        {
            remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num = num / 10;
        }
        return (reverse == x);
    }


}
