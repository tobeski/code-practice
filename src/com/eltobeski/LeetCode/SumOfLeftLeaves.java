package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left != null){
            if(root.left.left==null&&root.left.right==null)
                return root.left.data + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
