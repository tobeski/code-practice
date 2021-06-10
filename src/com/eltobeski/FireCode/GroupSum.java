package com.eltobeski.FireCode;

public class GroupSum {
    public static boolean groupSum(int[] arr, int target) {
        return groupSumHelper(0,arr,target);

    }

    private static boolean groupSumHelper(int index,int[] arr,int current){
        if(index>=arr.length)
        {
            return current == 0;
        }
        return groupSumHelper(index+1,arr,current-arr[index])||groupSumHelper(index+1,arr,current);
    }

    public static void main(String[] args) {
        System.out.println(groupSum(new int[]{3,4,10,2},0));
        System.out.println("Hello".substring(1));
    }
}
