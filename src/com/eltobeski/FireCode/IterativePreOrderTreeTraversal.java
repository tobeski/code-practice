package com.eltobeski.FireCode;

import java.util.*;

public class IterativePreOrderTreeTraversal {
    public ArrayList<Integer> preorderItr(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
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

    static private List<Integer> performPreorderItrII(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
    /*

    Stack: {}

    Result: {9,6,2,12,1,65,5,4,10,8}
    9 -> 6 , 9 -> 4

    */
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        result.add(root.data);
        stack.push(root);

        // {}
        while(!stack.isEmpty()){

            TreeNode currTop = stack.peek();
            while(currTop.left != null){
                result.add(currTop.left.data);
                stack.push(currTop.left);

                currTop = stack.peek();
            }


            TreeNode top = stack.pop(); // 9

            while (!stack.isEmpty() && top.right == null) {
                top = stack.pop();
            }

            if (top.right != null){
                result.add(top.right.data);
                stack.push(top.right);
            }
        }

        return result;
    }
}
