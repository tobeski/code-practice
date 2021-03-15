package com.eltobeski.FireCode;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePreOrderTreeTraversal {
    public ArrayList<Integer> preorderItr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode node ;
        if(root==null)
            return list;
        stack.push(root);
        while(!stack.isEmpty()){
            node = stack.pop();
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
            list.add(node.data);
        }
        return list;


    }
}
