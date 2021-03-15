package com.eltobeski.FireCode.FindMaxIntInABinaryTree;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindMaxIntInBinaryTree {
    public int findMaxItr(TreeNode root) {

        Deque<TreeNode> queue = new ArrayDeque<>();

        //Would add a null check but the return is an int meaning I cant return null; And no default value was stated
        queue.offer(root);
        int maxVal = root.data;


        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.data > maxVal){
                maxVal = curr.data;
            }

            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
        }
        return maxVal;





    }
}
