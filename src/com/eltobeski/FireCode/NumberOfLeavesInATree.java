package com.eltobeski.FireCode;

import java.util.Stack;

public class NumberOfLeavesInATree {
    public int numberOfLeaves(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node;

        int leaves = 0;
        if(root!=null){
            stack.add(root);
            while(!stack.isEmpty()){
                node = stack.pop();
                if(node.left==null && node.right==null){
                    leaves++;
                    continue;
                }
                if(node.right!=null)
                    stack.push(node.right);
                if(node.left!=null)
                    stack.push(node.left);
            }
        }
        return leaves;

    }

    public int numberOfLeavesRecursion(TreeNode root) {
        // Add your code below this line. Do not modify any other code.

        // Add your code above this line. Do not modify any other code.

        if (root==null){
            return 0;
        }
        if(root.left==null && root.right ==null){
            return 1;
        }

        return numberOfLeaves(root.left)+numberOfLeaves(root.right);
    }
}
