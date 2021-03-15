package com.eltobeski.LeetCode;

import java.util.Arrays;

public class MaximumByOneSwap {
    public static int maximumSwap(int num){

        char[] s =  (num+"").toCharArray();

        for(int i=0;i<s.length;i++){
            int max = i;
            for (int j=i;j<s.length;j++){

                if(s[j]-'0'>=s[max]-'0'){
                    max = j;
                }
            }
            if(max!=i && s[i]<s[max]){
                //switchTheNumbers
                char temp = s[max] ;
                s[max] = s[i] ;
                s[i] = temp;
                break;
            }
        }

        return Integer.valueOf(new String(s));
    }
public static void main(String[] args){
        System.out.println(maximumSwap(1993));
}
}
