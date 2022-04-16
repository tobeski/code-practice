package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {
    static   List<List<Integer>>  answers = new ArrayList<>();

    public static List<List<Integer>> threeSumFailed(int[] nums) {
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

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3)
            return List.of();

        List<List<Integer>> answers = new ArrayList<>();
        Arrays.sort(nums);


        for(int i = 0;i< nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum==0){
                    answers.add(List.of(nums[i], nums[j],nums[k]));
                    k--;

                    while( k>=0 &&nums[k]==nums[k+1] )
                        k--;
                }

                else if(sum > 0){
                    k--;
                    while(k>=0 && nums[k]==nums[k+1]  )
                        k--;
                }
                else {
                    j++;
                    while(j<nums.length && nums[j]==nums[j-1]  )
                        j++;
                }
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
