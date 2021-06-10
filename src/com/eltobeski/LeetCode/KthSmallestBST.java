package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class KthSmallestBST {
    public static int kthSmallest(TreeNode root, int k) {
        if(root==null)
            return Integer.MIN_VALUE;
        int[] answer = new int[]{1,0};
        kthSmallestUtil(root,k,answer);
        return answer[1];
    }

    public static void kthSmallestUtil(TreeNode root, int k,int[] curr) {
        if(root==null)
            return;

        kthSmallestUtil(root.left,k,curr);
        if(k==curr[0]){
            curr[1] = root.data;
            curr[0]++;
            return;
        }
        curr[0]++;
        kthSmallestUtil(root.right,k,curr);
    }

    public static void main(String[] args) {
        TreeNode head = restoreTree("9,6,12,5,8,11,15,4,*");
        System.out.println(kthSmallest(head,7));
    }
}
