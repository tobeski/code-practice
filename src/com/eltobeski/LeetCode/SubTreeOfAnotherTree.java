package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

public class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {


        if (t == null ^ s==null) return false;

        boolean subCheck = false;
        if (s.data == t.data) {
            subCheck =  isIdentical(s, t);
        }

        return subCheck || isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    public boolean isIdentical(TreeNode s,TreeNode t){
        if(s==null && t == null) return true;
        if(s==null || t == null) return false;

        if(s.data != t.data) return false;

        return  isIdentical(s.left,t.left) && isIdentical(s.right,t.right);
    }
}
