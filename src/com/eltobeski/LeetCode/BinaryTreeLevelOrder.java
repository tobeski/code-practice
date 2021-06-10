package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> answer = new ArrayList<>();

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);
            List<Integer> currentList = new ArrayList<>();

            while (true) {
                if (!currentList.isEmpty())
                    answer.add(currentList);
                int queueSize = deque.size();
                if (queueSize == 0)
                    break;
                currentList = new ArrayList<>();
                while (queueSize > 0) {
                    TreeNode currNode;
                        currNode = deque.poll();
                        if (currNode.left != null)
                            deque.offer(currNode.left);
                        if (currNode.right != null)
                            deque.offer(currNode.right);

                    currentList.add(currNode.data);

                    queueSize--;
                }

            }
            return answer;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> levelOrder = levelOrder(root);
        System.out.println(levelOrder);
    }
}
