package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

public class MaximumBinaryTree {
    public  static TreeNode constructMaximumBinaryTree(int[] nums) {

     return   constructMaxBinaryT(0, nums.length, nums);
    }

    public  static TreeNode constructMaxBinaryT(int leftIndex, int rightIndex, int[] nums) {
        if (leftIndex == rightIndex ) return null;
        int maxPos = findMaxWithinLimits(leftIndex, rightIndex, nums);
        TreeNode treeNode = new TreeNode(nums[maxPos]);
        treeNode.left = constructMaxBinaryT(leftIndex, maxPos , nums);
        treeNode.right = constructMaxBinaryT(maxPos+1 , rightIndex, nums);
        return treeNode;

    }

    private static int findMaxWithinLimits(int start, int end, int[] nums) {
        int maxPos = start;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
        }
        return maxPos;
    }

    public static void main(String[] args){
       int[] nums = new int[]{3,2,1,6,0,5};
     TreeNode treeNode =  constructMaximumBinaryTree(nums);
     System.out.println(treeNode.data);

    }
}
