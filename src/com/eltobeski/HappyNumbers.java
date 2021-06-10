package com.eltobeski;

import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {
    public static Set<Integer> numbers = new HashSet<>();
    public static boolean isHappyNumber(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        if(numbers.contains(n))
            return false;

        int sum = computeSquares(n);
        if(sum==1)
            return true;



        numbers.add(n);
        return isHappyNumber(sum);

    }

    public static int computeSquares(int x){
        String xString = x+"";
        int sum=0;
        for(Character c:xString.toCharArray()){
            int num = Integer.parseInt(c.toString());
            sum += (num*num);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(12));
    }
}
