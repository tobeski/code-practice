package com.eltobeski.HackerRank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class EqualStack {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        int h1Sum = findSum(h1);
        int h2Sum = findSum(h2);
        int h3Sum = findSum(h3);
        int minimum = findMinimum(h1Sum,h2Sum,h3Sum);

        //int maxLength = Math.max(Math.max(h1.length,h2.length),h3.length);
        int i = 0;
        int j = 0;
        int k = 0;

        while(minimum>0){
            if(h1Sum==h2Sum && h2Sum == h3Sum)
                return h1Sum;
            if(h1Sum>minimum){
                h1Sum -= h1[i];
                i++;
            }
            if(h2Sum>minimum){
                h2Sum -= h2[j];
                j++;
            }
            if(h3Sum>minimum){
                h3Sum -= h3[k];
                k++;
            }
            minimum = findMinimum(h1Sum,h2Sum,h3Sum);
            //maxLength = findMaximum(h1.length-i,h2.length-j,h3.length-k);
        }
        return minimum;

    }

    public static int findMinimum(int h1,int h2,int h3){
        return Math.min(Math.min(h1,h2),h3);
    }
    public static int findMaximum(int h1,int h2,int h3){
        return Math.max(Math.max(h1,h2),h3);
    }


    public static int findSum(int[] stack){
        int sum = 0;
        for(int i : stack){
            sum += i;
        }
        return sum;
    }


    public static void main(String[] args) throws IOException {
       int[] h1 = new int[]{1, 1,1 ,1, 2};
       int[] h2 = new int[]{3, 7};
       int[] h3 = new int[]{1,3,1};

        int result = equalStacks(h1, h2, h3);
        System.out.println(result);


    }
}
