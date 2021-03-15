package com.eltobeski.FireCode;

import java.util.LinkedList;
import java.util.Queue;

public class AreBinaryTreesIdentical {
    public static boolean isIdentical(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> lTree = new LinkedList<>();
        Queue<TreeNode> rTree = new LinkedList<>();


        if((root1==null && root2!=null)||(root1!=null&&root2==null)) {
            return false;
        }
        if(root1==null && root2==null) return true;



        lTree.offer(root1);
        rTree.offer(root2);

        while(!lTree.isEmpty() && !rTree.isEmpty()){
            TreeNode leftNode = lTree.poll();
            TreeNode rightNode = rTree.poll();

            if(leftNode.data != rightNode.data)
                return false;

            if(leftNode.left!=null)
                lTree.offer(leftNode.left);
            if(leftNode.right!=null)
                lTree.offer(leftNode.right);
            if(rightNode.left!=null)
                rTree.offer(rightNode.left);
            if(rightNode.right!=null)
                rTree.offer(rightNode.right);
        }

        return lTree.isEmpty() && rTree.isEmpty();

    }

    public static void main(String[] args){
        TreeNode rTree = BinaryTreeSerialization.restoreTree("1,2,3,4,5,6,7,8,*,*,*,*,*,*,*");
        TreeNode lTree = BinaryTreeSerialization.restoreTree("1,2,3,4,5,6,7,*,*,*,*,*,*,*,*");

        System.out.println(isIdentical(lTree,rTree));
    }
}
