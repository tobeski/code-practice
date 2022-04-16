package com.eltobeski.FireCode;

public class MaximumInBST {
    public int maxData(TreeNode root) {
        // Add your code here
        if(root==null)
            return Integer.MIN_VALUE;

        return Math.max(root.data,maxData(root.right));
    }
}
