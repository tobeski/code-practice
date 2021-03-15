package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.BinaryTreeSerialization;
import com.eltobeski.FireCode.TreeNode;

public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        if(root.left==null&root.right!=null){
            return 1 + minDepth(root.right);
        }if(root.right==null&root.left!=null){
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode = BinaryTreeSerialization.restoreTree("3,9,20,*,*,15,7");
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;

            System.out.println(minDepth(treeNode));
    }
}
