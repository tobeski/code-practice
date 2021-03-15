package com.eltobeski.Random;

import com.eltobeski.FireCode.TreeNode;

import java.util.Comparator;
import java.util.TreeMap;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class BinaryTreeMirror {
    public static void mirror(TreeNode root){
        if(root == null) return;


        TreeNode temp = root.left;
        root.left =   root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);


        TreeMap<String,Integer> tm = new TreeMap<>();

    }

    public static void main(String[] args){
        TreeNode head = restoreTree("9,6,12,5,8,11,15,4,*");
        TreeNode mirror = restoreTree("9,12,6,15,11,8,5,*,*,*,*,*,*,*,4");
        System.out.println("Before:-");
        PrintBSTInOrder.inOrderTraversal(head);
        System.out.println("");

        PrintBSTInOrder.inOrderTraversal(mirror);
        mirror(head);
        System.out.println("");
        System.out.println("After:-");

        PrintBSTInOrder.inOrderTraversal(head);
        System.out.println("");
        PrintBSTInOrder.inOrderTraversal(mirror);

    }
}
