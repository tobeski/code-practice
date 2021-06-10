package com.eltobeski.FireCode;

public class InsertIntoBST {

    public TreeNode insert(TreeNode root, int data) {
        if(root==null){
            return new TreeNode(data,null,null);
        }

        if(data<root.data)
        {
            root.left = insert(root.left,data);
        }

        if(data>root.data)
        {
            root.right = insert(root.right,data);
        }

        return root;

    }


}
