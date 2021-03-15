package com.eltobeski.FireCode;

import java.util.LinkedList;
import java.util.Queue;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class NumberOfHalfNodes {
    public static int numberOfHalfNodes(TreeNode root) {


        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;

        int leaves = 0;
        if (root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                node = queue.poll();
                if (node.left == null ^ node.right==null) {
                    leaves++;
                }
                if (node.right != null)
                    queue.offer(node.right);
                if (node.left != null)
                    queue.offer(node.left);
            }
        }
        return leaves;

    }

    public static void main(String[] args){
        TreeNode head = restoreTree("3,*,9,*,*,4,*");
        System.out.println(numberOfHalfNodes(head));

    }
}
