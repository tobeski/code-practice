package com.eltobeski.Random;

import com.eltobeski.FireCode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class LongestDistinctPathInABinaryTree {
 private static int longestDistinctPath(TreeNode root){
     int[] max = {1};
     helper(root, new HashSet<>(),max);
     return max[0];
     //Generate Maximum left path recursively
     //Generate right path recuresively
     //Check max of left + right path + current is greater than current max
     // return root + maximum of left/right path
 }

    private static int helper(TreeNode node, Set<Integer> foundValues,int[] max){
        if(node == null||foundValues.contains(node.data))
            return foundValues.size();

        foundValues.add(node.data);

         max[0] = Math.max(Math.max(helper(node.left,foundValues, max),helper(node.right,foundValues, max)),max[0]);

        foundValues.remove(node.data);

        return max[0];
    }

    public static void main(String[] args) {
        TreeNode head = restoreTree("1,2,3,3,6,3,1,2,*,*,*,*,*,5,6");
        TreeNode head2 = restoreTree("1,*,2,1,1,*,*,4,*");
        TreeNode head3 = restoreTree("1,2,2,1,2,4,1");
        System.out.println(longestDistinctPath(head));
        System.out.println(longestDistinctPath(head2));
        System.out.println(longestDistinctPath(head3));
    }
}
