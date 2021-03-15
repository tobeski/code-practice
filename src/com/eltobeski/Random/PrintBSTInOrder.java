package com.eltobeski.Random;

import com.eltobeski.FireCode.TreeNode;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class PrintBSTInOrder {

    public static void inOrderTraversal(TreeNode root){
        if(root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args){
        TreeNode head = restoreTree("9,6,12,5,8,11,15,4,*");

        inOrderTraversal(head);
    }
}
