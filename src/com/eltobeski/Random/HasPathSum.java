package com.eltobeski.Random;

import com.eltobeski.FireCode.TreeNode;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class HasPathSum {
    public static boolean hasPathSum(TreeNode root,int pathSum,int[] sum){
        if(root == null && pathSum==sum[0]) return true;
        if(root == null) return false;

        pathSum= pathSum+root.data;
       return hasPathSum(root.left,pathSum,sum)||
        hasPathSum(root.right,pathSum,sum);
    }

    public static void main(String[] args){
        TreeNode head = restoreTree("9,6,12,5,8,11,15,4,*");
        int[] sum = new int[]{25};
        System.out.println(hasPathSum(head,0,sum));
    }
}
