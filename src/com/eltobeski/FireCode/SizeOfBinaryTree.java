package com.eltobeski.FireCode;

public class SizeOfBinaryTree {
    public int size(TreeNode root) {
        int size = 1;
        if(root==null)
            return 0;

        size += size(root.left) + size(root.right);

        return size;



    }
}
