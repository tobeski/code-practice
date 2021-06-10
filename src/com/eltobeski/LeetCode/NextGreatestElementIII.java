package com.eltobeski.LeetCode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class NextGreatestElementIII {
    public static int nextGreaterElement(int n) {

        int[] numArray = convertIntegerToIntArray(n);
        if(numArray.length<2)
            return -1;
        if(numArray.length==2 && numArray[0]>numArray[1])
            return -1;
        for (int i = numArray.length-2; i >=0; i--) {
            if(numArray[i+1]>numArray[i]){
                return index;
            }
        }
        return  -1;
        moveOnceToLeft(numArray,maxIndex);
        sortDigitsAfterMax(numArray,maxIndex);
        try {

            return convertIntArrayToInt(numArray);
        }
        catch (Exception ex) {
            return -1;
        }
    }

    private static int searchForIndexSmallestAfterKey(int[] n,int lowerEnd,int upperEnd){
        int middle = 0;
        while (lowerEnd <= upperEnd) {
            middle = (lowerEnd + upperEnd) / 2;

            if (n[middle] == n) {
                return true;
            }

            if (arr[middle] < n) {
                lowerEnd = middle + 1;
            } else {
                upperEnd = middle - 1;
            }
        }

        return false;
    }

    }

    private static void moveOnceToLeft(int[] n,int index){
        int temp = n[index];
        n[index] =n[index-1];
        n[index-1] = temp;

    }

    private static void sortDigitsAfterMax(int[] n,int maxIndex){

        Set<Integer> treeSet = new TreeSet<>();
        int  currIndex = maxIndex;
        for (int i = maxIndex; i < n.length; i++) {
            treeSet.add(n[i]);
        }
        for (int nextDigit : treeSet) {
            n[currIndex] = nextDigit;
            currIndex++;
        }
    }


    private static int[] convertIntegerToIntArray(int n){
        String numAsString = n+"";
        int[] numArray = new int[numAsString.length()];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.parseInt(numAsString.charAt(i)+"");
        }
        return numArray;
    }
    private static int convertIntArrayToInt(int[] n){
        int num = 0;
        for (int a : n) {
            num = 10*num + a;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
        System.out.println(nextGreaterElement(231));
        System.out.println(nextGreaterElement(2896));
    }
}
