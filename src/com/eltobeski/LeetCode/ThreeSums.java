package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {
    static   List<List<Integer>>  answers = new ArrayList<>();

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>(),0);
        return answers;
    }

    private static void helper(int[] candidiates,int target,List<Integer> integerList,int i){
        if(target==0&&integerList.size()==3) {
            answers.add(integerList);
            return;
        }

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
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
