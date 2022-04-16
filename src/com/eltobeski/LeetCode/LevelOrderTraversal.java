package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)
            return new ArrayList<>();
        queue.offer(root);
        List<List<Integer>> answer = new ArrayList<>();

        while (true){
            int size = queue.size();

            if(size==0)
                break;

            List<Integer> level = new ArrayList<>();
            while (size>0){
                TreeNode curr = queue.poll();
                level.add(curr.data);
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
                size--;
            }
            answer.add(level);
        }
        return answer;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> levelOrder = levelOrder(root);
        System.out.println(levelOrder);
    }

}
