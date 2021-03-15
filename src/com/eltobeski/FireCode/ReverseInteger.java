package com.eltobeski.FireCode;

import java.util.HashSet;
import java.util.Set;

public class ReverseInteger {
    public static int reverseInt(int x) {
        int num = x;
        int reverse =0;
        int remainder =0;
        while(num!=0){
            remainder = num%10;
            reverse = reverse * 10 + remainder;
            num = num/10;
        }

        return reverse;



    }

    //
    public static int reverse(int x) {
        boolean isNegative = false;
        if(x<0){
            isNegative = true;
            x = -1 * x;

        }

        if (x ==0) return 0;


        int num = 0;
        while(x!=0){
            int rem = x % 10;
            if (num > (Integer.MAX_VALUE - rem)/10) {
                return 0;
            }
            num = num *10 + rem;
            x= x/10;
        }
        if (isNegative){
            return -1 * num;
        }
        return num;
    }

    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }
}
