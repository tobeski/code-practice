package com.eltobeski.FireCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {
    public static int findMissingNumber(int[] arr) {

        int sum = 0;
        int arraySum = 0;
        for(int i = 1;i<=10;i++){
            sum += i;
        }
        for(int i = 0; i < 9;i++){
            arraySum += arr[i];
        }

        return sum - arraySum;

    }



    public static void main(String[] args) {
        // write your code here
        int[] arrayOfNumbers = {2, 8, 3, 4, 5, 6, 7, 9, 10};
        System.out.println(findMissingNumber(arrayOfNumbers));
    }
}
