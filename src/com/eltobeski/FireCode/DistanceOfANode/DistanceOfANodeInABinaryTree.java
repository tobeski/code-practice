package com.eltobeski.FireCode.DistanceOfANode;

import com.eltobeski.FireCode.TreeNode;

public class DistanceOfANodeInABinaryTree {
    public int pathLengthFromRoot(TreeNode root, int n1) {
        return findDist(root,n1);
    }

    // distance
    private int findDist(TreeNode node, int val){
        if(node == null){
            return 0;
        }

        if(node.data == val){
            return 1;
        }

        //  traverse left and right
        int left = findDist(node.left, val);
        int right = findDist(node.right, val);

        if (left > 0) {
            return left + 1;
        }

        if (right > 0){
            return right + 1;
        }
        /*
                A -> 1
               / \
              K   B
             / \
            J   B
           /
          S

          Recursion
          - Know your base case
          - Solve for 1, 2 or 3 levels (never more, no let your head pain you)
            - Determine how to get your final value
          - Know the arguments you want to pass in each call
          - Find out if you need conditionals
          - Determine how to
        */

        return 0;
    }
}
