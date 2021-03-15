package com.eltobeski.FireCode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfFullNodes {
    public int numberOfFullNodes(TreeNode root) {
        if(root == null) return 0;

        int fullNodeCount = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.left!=null && node.right!= null) fullNodeCount++;

            if(node.left != null) queue.offer(node.left);

            if(node.right != null) queue.offer(node.right);
        }


        return fullNodeCount;




    }
}
