package com.eltobeski.FireCode.FindAncestorsInABinaryTree;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayList;

public class FindAncestorsInABinaryTree {
    public ArrayList<Integer> ancestorsList = new ArrayList<>();
    public boolean printAncestors(TreeNode root, int nodeData) {
        if(root==null)
            return false;
        if(root.data == nodeData){
            return true;
        }

        if(printAncestors(root.left,nodeData)||printAncestors(root.right,nodeData)){
            ancestorsList.add(root.data);
            return true;
        }

        return false;

    }
}
