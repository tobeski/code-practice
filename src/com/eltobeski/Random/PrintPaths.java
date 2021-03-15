package com.eltobeski.Random;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayList;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class PrintPaths {

    public static void printPaths(TreeNode root, String path) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            String c = path + " " + root.data;
            System.out.println(c);
            return;
        }
        String c = path + " " + root.data;
        printPaths(root.left, c);
        printPaths(root.right, c);
    }

    public static void main(String[] args) {
        TreeNode head = restoreTree("9,6,12,5,8,11,15,4,*");
        int[] sum = new int[]{25};
        printPaths(head, "");
    }
}
