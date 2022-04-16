package com.eltobeski.LeetCode;

public class MaximumSubArray {
    //Find if they all negative in the array
    // If all negative get the smalllest negative as the max
    //Else keep summing if the sum <0 drop off the current sum and subarr and start from where you are
    //All the while recognsing the max value
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        if(!allNegative(nums)){
            for (int num : nums) {
                sum += num;
                if (sum < 0)
                    sum = 0;
                max = Math.max(sum, max);
            }
        }
        else {
            max = nums[0];
            for (int num:nums
                 ) {
                if(num>max)
                    max =num;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }

    private static boolean allNegative(int[] nums){
        for (int num :nums
             ) {
            if(num>=0)
                return false;
        }
        return true;
    }

}
