package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
  static   List<List<Integer>>  answers = new ArrayList<>();
    public static   List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target,new ArrayList<>());
        return answers;
    }

    private static void helper(int[] candidiates,int target,List<Integer> integerList){
        if(target==0) {
            answers.add(integerList);
            return;
        }
        if(target<0)
            return;
        for (int candidate:candidiates
             ) {
            if (!integerList.isEmpty() && integerList.get(integerList.size()-1) > candidate) {
                continue;
            }
                List<Integer> integers = new ArrayList<>(integerList);
                integers.add(candidate);
                helper(candidiates, target - candidate, integers);
            }

    }

    public static void main(String[] args) {
        System.out.println(CombinationSum.combinationSum(new int[]{2,3,5},8));
    }


}
