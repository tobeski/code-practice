package com.eltobeski.LeetCode;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int endVal = nums.length-1;
        while(endVal>=0&&nums[endVal]==val)
            endVal--;
        int i=0;
        while(i<endVal){
            if(nums[i]!=val)
            {
                i++;
            }
            else{
                int temp = nums[i];
                nums[i] = nums[endVal];
                nums[endVal] = temp;
                while(endVal>i&&nums[endVal]==val)
                    endVal--;
            }
        }
        return endVal+1;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
        System.out.println(removeElement(new int[]{3,2,2,3},2));
    }
}
