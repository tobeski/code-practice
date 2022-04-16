package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root,null,null);
    }


    private boolean isValidBSTHelper(TreeNode root,Integer min,Integer max){
        if(root==null)
            return true;
        if((min!=null && root.data<=min)||(max!=null && root.data>=max)){
            return false;
        }

        return isValidBSTHelper(root.left,min,root.data)&&isValidBSTHelper(root.right,root.data,max);
    }
}
