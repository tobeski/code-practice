package com.eltobeski.FireCode;

public class ValidateBSTTree {
    public static boolean validateBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    public static boolean validateBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null &&root.data < min) || (max != null && root.data > max)) {
            return false;
        }
        // left subtree must be < root.val && right subtree must be > root.val
        return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
    }
}
