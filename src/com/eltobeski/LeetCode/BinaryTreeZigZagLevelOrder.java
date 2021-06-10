package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

import java.util.*;

public class BinaryTreeZigZagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> answer = new ArrayList<>();

        Deque<TreeNode> zigZag = new ArrayDeque<>();
        zigZag.add(root);
        boolean isOddLevel = true;
        List<Integer> currentList = new ArrayList<>();

        while (true) {
            if (!currentList.isEmpty())
                answer.add(currentList);
            int queueSize = zigZag.size();
            if (queueSize == 0)
                break;
            currentList = new ArrayList<>();
            while (queueSize > 0) {
                TreeNode currNode;
                if (isOddLevel) {
                    currNode = zigZag.pollFirst();
                    if (currNode.left != null)
                        zigZag.offerLast(currNode.left);
                    if (currNode.right != null)
                        zigZag.offerLast(currNode.right);
                } else {
                    currNode = zigZag.pollLast();
                    if (currNode.right != null)
                        zigZag.offerFirst(currNode.right);
                    if (currNode.left != null)
                        zigZag.offerFirst(currNode.left);
                }
                currentList.add(currNode.data);

                queueSize--;
            }
            isOddLevel = !isOddLevel;

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
        List<List<Integer>> levelOrder = zigzagLevelOrder(root);
        System.out.println(levelOrder);
    }

}
