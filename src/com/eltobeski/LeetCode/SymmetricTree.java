package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        return treeHelper(root.right,root.left);
    }

    public static boolean treeHelper(TreeNode rightTree,TreeNode leftTree){
        if(rightTree != null && leftTree != null){
            if(rightTree.data==leftTree.data) {
                return treeHelper(rightTree.left, leftTree.right) && treeHelper(rightTree.right, leftTree.left);
            }
            return false;
        }
        else if(rightTree==null && leftTree==null) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode head = restoreTree("1,2,2,3,4,4,3");
        System.out.println(isSymmetric(head));
    }
}
