package com.eltobeski.LeetCode;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {
        if (k > nums.length||k==0)
            return Integer.MIN_VALUE;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i:nums
             ) {
            priorityQueue.offer(i);

            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }

        }
        return priorityQueue.peek();

    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4, 8};
        System.out.println(findKthLargest(arr, 1));
    }
}
