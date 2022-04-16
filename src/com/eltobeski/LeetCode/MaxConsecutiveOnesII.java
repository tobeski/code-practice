package com.eltobeski.LeetCode;

public class MaxConsecutiveOnesII {

    public static int maxConsecutiveOnes(int[] numbers){
        //loop through
        //Have a found zero boolean
        //If zero found continue
        //If new zero found starting point is end of previous zero
        boolean zeroFound = false;
        int zeroIndex = -1;
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i <numbers.length ; i++) {
            if(numbers[i]==0)
            {
                if(zeroFound)
                {
                    start=zeroIndex+1;
                    zeroIndex = i;
                    maxLength = Math.max(maxLength, i - start + 1);
                }
                else {
                    zeroFound = true;
                    zeroIndex = i;
                    maxLength = Math.max(maxLength, i - start + 1);

                }
            }
            else {
                maxLength = Math.max(maxLength, i - start + 1);
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(new int[]{1,0,1,1,0}));
        System.out.println(maxConsecutiveOnes(new int[]{1,0,1,1,0,1,1,1,1,0}));
    }
}
