package com.eltobeski.LeetCode;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class PreviousPermutationWithOneSwap {
    public static int[] prevPermOpt1(int[] A) {
        int index = -1;
        int firstIndex = -1;
        int length = A.length;

        for(int i=length-1;i>0;i--){
            if(A[i-1] > A[i]){
                firstIndex = i-1;
                break;
            }
        }

        if(firstIndex == -1)
            return A;

        int firstNumber = A[firstIndex];
        int secondIndex = firstIndex+1;

        for(int i = firstIndex +1 ; i<length;i++){
            if(A[i]>A[secondIndex] && A[i] < firstNumber){
                secondIndex = i;
            }
        }

        int temp = A[firstIndex];
        A[firstIndex] = A[secondIndex];
        A[secondIndex] = temp;

        return A;
    }

    public static void main(String[] args){
        int [] num = new int[]{3,1,1,3};
        int [] newNum = prevPermOpt1(num);
        newNum = num;
    }
}

