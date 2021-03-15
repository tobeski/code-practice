package com.eltobeski.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class FindFirstDuplicate {
    public static int firstDuplicate(int[] numbers){
        HashMap<Integer,Integer> numbersIndex = new HashMap<>();
        HashSet<Integer> found = new HashSet<>();
        for (int i=0;i<numbers.length;i++) {
            if(!numbersIndex.containsKey(numbers[i])){
                numbersIndex.put(numbers[i],i);
            }
            else {
                found.add(numbers[i]);
            }

        }
        int max = Integer.MAX_VALUE;
        for (int i:found
             ) {
          max =   Math.min(numbersIndex.get(i),max);
        }
        return numbers[max];

    }


    public static void main(String[] args){
        System.out.println(firstDuplicate(new int[]{3,4545,3,4,4,4545,4545,3332,3434,554}));
    }
}
