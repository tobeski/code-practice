package com.eltobeski.FireCode;

public class DiameterOfABST {
    public int diameter(TreeNode root) {
        if(root==null)
            return 0;

        return Math.max(1 + findHeight(root.left)+findHeight(root.right),Math.max(diameter(root.left),diameter(root.right)));



    }

    public int findHeight(TreeNode root) {
        /* base case tree is empty */
        if(root == null) return 0;
        /* If tree is not empty then height = 1 + max of left
            height and right heights */
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}
