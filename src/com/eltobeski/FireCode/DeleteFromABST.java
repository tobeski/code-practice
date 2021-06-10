package com.eltobeski.FireCode;

public class DeleteFromABST {

    /*
    1. First case: left and right child nodes are null.

Simply remove the node from the tree.

2. Second and Third cases: Either the Left child node or the right child node is null .

Remove the node and replace it with its child.

3. Fourth case: Left and right child nodes are not null.

 Find the node with the minimum value in the right subtree of the node to be deleted. Put this minimum value in the node to be deleted. Delete the node which had the minimum value.
     */
//    public TreeNode delete(TreeNode root, int data) {
//
//
//
//    }

    public void deleteHelper(TreeNode root, int data) {

        if(root==null)
            return;
        if(root.data == data){

            if(root.left==null&&root.right==null) {
                root = null;
                return;
            }
            else if(root.left!=null && root.right==null)
            {
                int x = removeMinimumNode(root);
                root.data = x;
                return;
            }
            else if(root.left != null)
            {
                root = root.left;
            }


        }


    }

    public int removeMinimumNode(TreeNode root) {
        TreeNode curr = root;
        while (curr.left.left!=null)
            curr = curr.left;

        int min = curr.left.data;
        curr.left = null;

        return min;

    }

}
