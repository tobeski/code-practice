package com.eltobeski.LeetCode;

import java.util.HashMap;
import java.util.Map;

class MajorityElement {
    public static int majorityElement(int[] nums) {
        int maxElem = 0;
        Map<Integer,Integer> elemFreq = new HashMap<>();
        int majorNum = nums.length/2;
        for (int num:nums
             ) {
            int numFrequency = elemFreq.getOrDefault(num,0);
            numFrequency++;
            if(numFrequency>= majorNum && numFrequency>elemFreq.getOrDefault(maxElem,0)) {
                maxElem  = num;
            }
            elemFreq.put(num,numFrequency);
        }
        return maxElem;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}