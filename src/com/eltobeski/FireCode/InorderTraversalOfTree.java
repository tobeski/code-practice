package com.eltobeski.FireCode;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversalOfTree {
    public ArrayList<Integer> inorderItr(TreeNode root) {


        ArrayList<Integer> answer = new ArrayList<>();
        if(root==null) return answer;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            if(stack.isEmpty()) break;
            node = stack.pop();
            answer.add(node.data);
            node = node.right;
        }
        return answer;


    }
}
