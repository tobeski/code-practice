package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class PathSumII {
    static List<List<Integer>> answers;
    static List<Integer> list;

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        answers = new ArrayList<>();
        list = new ArrayList<>();
        if(root==null)
            return new ArrayList<>();
        pathSumUtil(root, targetSum);
        return answers;
    }

    private static void pathSumUtil(TreeNode root, int target) {
        list.add(root.data);
        if (root.left == null && root.right == null && root.data == target) {
            answers.add(new ArrayList<>(list));

        }
        if (root.left != null)
            pathSumUtil(root.left, target - root.data );
        if (root.right != null)
            pathSumUtil(root.right, target - root.data);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode head = restoreTree("5,4,8,11,*,13,4,7,2,*,*,5,1");
        System.out.println(pathSum(head, 22));
    }
}
