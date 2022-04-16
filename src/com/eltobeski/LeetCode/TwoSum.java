package com.eltobeski.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public  static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> arrayMap = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            arrayMap.put(nums[i], i);
        }
        int[] arrayResult =new int[2];
        for(int i = 0; i<nums.length; i++){


            int CurrentElementInIteration = nums[i];
            int result= target-CurrentElementInIteration;
            if(arrayMap.containsKey(result)){
                if(i== arrayMap.get(result))
                    continue;
                arrayResult[0] = i;
                arrayResult[1] = arrayMap.get(result);
                break;
            }
        }

        return arrayResult;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4},6)));
    }
}
