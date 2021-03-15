package com.eltobeski.FireCode;

import java.util.LinkedList;
import java.util.Queue;

public class FindNodeInABinaryTree{
        public TreeNode findNodeRecursive(TreeNode root, int val) {
            if(root == null || root.data == val) return root;

            TreeNode curr = findNodeRecursive(root.left,val);
            if(curr == null) curr = findNodeRecursive(root.right,val);
            return curr;
        }

    public TreeNode findNodeIterative(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.data==val){
                return curr;
            }
            if(curr.left!=null){
                queue.add(curr.left);
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }
        }
        return null;

    }

}
