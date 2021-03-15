package com.eltobeski.Random;

import com.eltobeski.FireCode.TreeNode;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class DoubleTree {

    public static void doubleTree(TreeNode root){
        if(root == null) return;

        TreeNode temp = new TreeNode(root.data);
   TreeNode t =  root.left;
    root.left = temp;
    temp.left = t;

        doubleTree(temp.left);
        doubleTree(root.right);
    }

    public static void main(String[] args){
        TreeNode head = restoreTree("9,6,12,5,8,11,15,4,*");
        doubleTree(head);
        PrintBSTInOrder.inOrderTraversal(head);


    }
}
