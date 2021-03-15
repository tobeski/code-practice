package com.eltobeski.FireCode;

import sun.text.normalizer.Trie;

public class FindMaximumDataInTree {
    public int findMax(TreeNode root) {
        if(root==null)
            return 0;

        return Math.max(root.data,Math.max(findMax(root.left),findMax(root.right)));

    }
}
