package com.eltobeski.FireCode.PrintByOrderLevelOfTraversal;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PrintByOrderLevelOfTraversal {
    public ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {

        ArrayList<ArrayList<Integer>> traversedTree = new ArrayList<>();
        if (root == null) {
            return traversedTree;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<Integer> levelList = new ArrayList<>();

        deque.offer(root);


        while(true) {
            int size = deque.size();
            if(!levelList.isEmpty())
                traversedTree.add(levelList);
            if(size==0)
                break;

            levelList = new ArrayList<>();
            while (size-- >0) {
                TreeNode node = deque.poll();
                levelList.add(node.data);

                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }

        return traversedTree;










    }
}
