package com.eltobeski.FireCode.FindTheSumOfAllNodes;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTheSumOfAllNodes {
    public int sumItr(TreeNode root) {
        int sum = 0;

        if (root == null) {
            return sum;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);



            while (!deque.isEmpty()) {
                TreeNode node = deque.poll();
                sum += node.data;

                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }


        return sum;

    }
}
