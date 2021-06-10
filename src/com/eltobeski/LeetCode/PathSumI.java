package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;
import static com.eltobeski.FireCode.BinaryTreeSerialization.serializeTree;

public class PathSumI {
    private static boolean pathSumUtil(TreeNode root, int target) {
        if(root==null)
            return false;

        if (root.left == null && root.right == null && root.data == target) {
            return true;

        }

          return pathSumUtil(root.left, target - root.data )||
          pathSumUtil(root.right, target - root.data);


    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSumUtil(root,targetSum);
    }


    public static void main(String[] args) {
        TreeNode head = restoreTree("5,4,8,11,*,13,4,7,2,*,*,5,1");
        System.out.println(hasPathSum(head, 22));
    }
}
