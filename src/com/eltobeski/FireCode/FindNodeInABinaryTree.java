package com.eltobeski.FireCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class FindNodeInABinaryTree{
        public TreeNode findNodeRecursive(TreeNode root, int val) {
            if(root == null || root.data == val) return root;

            TreeNode curr = findNodeRecursive(root.left,val);
            if(curr == null) curr = findNodeRecursive(root.right,val);
            return curr;
        }

    public static void main(String[] args) {
        TreeNode head = restoreTree("1,2,3,4,5,6,7");

        System.out.println(findNode(head,7));
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

    } private static Boolean findNode(TreeNode root, int n) {
        // Add your code here
        if(root==null){
            return false;
        }
        Deque<TreeNode> stack =  new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.data==n)
            {
                return true;
            }
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
        return false;
    }

}
