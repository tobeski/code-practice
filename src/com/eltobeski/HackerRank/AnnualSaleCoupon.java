package com.eltobeski.HackerRank;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AnnualSaleCoupon {
    public static void main(String[] args) {
        System.out.println(isValidStack("abba"));
    }

    private static List<Integer> findValidDiscountCoupon(List<String> data){
        List<Integer> result =  new ArrayList<>(data.size());
        for (String str: data) {
            boolean isValid =  isValid(str);
            int i = isValid? 1: 0;

            result.add(i);
        }

        return result;
    }

    public static boolean isValidStack(String coupon){
        if (coupon.length() % 2 == 1) {
            return false;
        }
        if(coupon.length()==0)
            return true;

        char[] couponArray = coupon.toCharArray();
        ArrayDeque<Character> characterStack = new ArrayDeque<>();
        characterStack.add(couponArray[0]);

        for (int i=1;i<couponArray.length;i++){
            if(!characterStack.isEmpty())
            {
               if( characterStack.peek()==couponArray[i])
                   characterStack.pop();
               else
                   characterStack.push(couponArray[i]);
            }else{
                characterStack.push(couponArray[i]);
            }

        }
        return characterStack.isEmpty();

    }

    public static boolean isValid(String coupon) {
        if (coupon.length() % 2 == 1) {
            return false;
        }
        if(coupon.length()==0)
            return true;

        char[] couponArray = coupon.toCharArray();

        if(couponArray[0]==couponArray[couponArray.length-1])
            return isValid(coupon.substring(1,coupon.length()-1));

        else if(couponArray[0]==couponArray[1])
            return isValid(coupon.substring(2));

        else return false;
    }


}
