package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {



        Arrays.sort(nums);
        int lowestSum = nums[0]+nums[1]+nums[2];
        if(lowestSum-target==0)
            return lowestSum;

        for(int i = 0;i< nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int k = nums.length-1;
            int j = i+1;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum-target==0)
                    return sum;
                if(Math.abs(target-sum)<Math.abs(target-lowestSum)){
                    lowestSum = sum;
                }

                if(sum > target){
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
        return lowestSum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,2,1,-3},1));
    }
}
