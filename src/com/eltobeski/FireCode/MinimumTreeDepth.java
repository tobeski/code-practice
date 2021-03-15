package com.eltobeski.FireCode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumTreeDepth {
    public int minTreeDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeLevel> queue = new LinkedList<>();
        queue.offer(new TreeLevel(root,1));

        while(!queue.isEmpty()){
            TreeLevel treeLevel = queue.poll();
            TreeNode node = treeLevel.treeNode;
            if(node.left==null && node.right==null) return treeLevel.level;
            if(node.left!=null)
                queue.offer(new TreeLevel(node.left,treeLevel.level+1));
            if(node.right!=null)
                queue.offer(new TreeLevel(node.right,treeLevel.level+1));
        }
        return 0;
    }

    public class TreeLevel{
        TreeNode treeNode;
        int level;

        public TreeLevel(TreeNode treeNode,int level){
            this.treeNode = treeNode;
            this.level = level;
        }
    }
}
