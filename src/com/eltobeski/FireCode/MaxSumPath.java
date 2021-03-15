package com.eltobeski.FireCode;

public class MaxSumPath {
    public static int maxSumPath(TreeNode root) {
        int[] max = {root.data};
        helper(root, max);
        return max[0];
        //Generate Maximum left path recursively
        //Generate right path recuresively
        //Check if leftPath + right path + root is greater than current max
        // return root + maximum of left/right path
    }

    private static int helper(TreeNode node, int[] max){
        if(node == null) return 0;

        int maxLeft = Math.max(helper(node.left, max),0);
        int maxRight = Math.max(helper(node.right, max),0);

        max[0] = Math.max(node.data + maxLeft + maxRight, max[0]);

        return node.data + Math.max(maxLeft, maxRight);
    }
}
