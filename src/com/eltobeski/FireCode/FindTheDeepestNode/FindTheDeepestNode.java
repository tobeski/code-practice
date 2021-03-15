package com.eltobeski.FireCode.FindTheDeepestNode;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class FindTheDeepestNode {
    public TreeNode findTheDeepestNode(TreeNode root) {

        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode lastNode = root;
        deque.offer(root);


        while(true) {
            int size = deque.size();

            if(size==0)
                break;

            while (size-- >0) {
                TreeNode node = deque.poll();
                lastNode = node;

                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }

        return lastNode;










    }
}
