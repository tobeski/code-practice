package com.eltobeski.FireCode.LevelOrderTraversal;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LevelOrderTraversal {
    public ArrayList<Integer> levelorder(TreeNode root) {
        ArrayList<Integer> traversedTree = new ArrayList<>();
        if (root == null) {
            return traversedTree;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            traversedTree.add(node.data);

            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
        }
        return traversedTree;

    }
}
