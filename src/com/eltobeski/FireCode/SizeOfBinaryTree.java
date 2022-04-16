package com.eltobeski.FireCode;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class SizeOfBinaryTree {
    public static int size(TreeNode root) {
        int size = 1;
        if(root==null)
            return 0;

        size += size(root.left) + size(root.right);

        return size;



    }

    public static int sizeOfufu(TreeNode root){
        if(root==null)
            return 0;

       return 1 + sizeOfufu(root.left) + sizeOfufu(root.right);


    }

    public static void main(String[] args) {
        TreeNode head = restoreTree("1,2,3,4,5,6,7,*,*,2,*,1,*,1,*");
        TreeNode head2 = restoreTree("1");

        System.out.println(size(head));
        System.out.println(sizeOfufu(head));
        System.out.println(size(head2));
        System.out.println(sizeOfufu(head2));

    }
}
