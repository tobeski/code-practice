package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    static   List<List<Integer>>  answers = new ArrayList<>();
    public static   List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,new ArrayList<>(),0);
        return answers;
    }

    private static void helper(int[] candidiates,int target,List<Integer> integerList,int i){
        if(target==0) {
            answers.add(integerList);
            return;
        }
        if(target<0)
            return;
        for (int j=i;j< candidiates.length;j++)
         {
            if (j>i && candidiates[j]==candidiates[j-1]) {
                continue;
            }
            List<Integer> integers = new ArrayList<>(integerList);
            integers.add(candidiates[j]);
            helper(candidiates, target - candidiates[j], integers,j+1);

        }

    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,5,2,1,2,2},4));
    }
}
