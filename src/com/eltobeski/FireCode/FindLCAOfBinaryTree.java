package com.eltobeski.FireCode;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class FindLCAOfBinaryTree {
    public static TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
        if(root==null)
            return null;
        if(root.data==a.data||root.data==b.data) {
            if(searchTreeNode(root,a)||searchTreeNode(root,b))
                return root;
            return null;
        }
        TreeNode[] data = new TreeNode[1];
        data[0] = null;
        if(searchTreeNode(root,a)&&searchTreeNode(root,b))
            data[0] = root;

        findLCAHelper(root,a,b,data);
        return data[0];
    }

    public static void findLCAHelper(TreeNode root, TreeNode a, TreeNode b,TreeNode[] data) {
        if(root!=null){


            if(searchTreeNode(root.left,a)&&searchTreeNode(root.left,b)){
                data[0] = root.left;
                findLCAHelper(root.left,a,b,data);
            }
            if(searchTreeNode(root.right,a)&&searchTreeNode(root.right,b)){
                data[0] = root.right;
                findLCAHelper(root.right,a,b,data);
            }
        }



    }

    public static boolean searchTreeNode(TreeNode root,TreeNode node){
        if(root==null)
            return false;

        if(node.data==root.data)
            return true;

        return searchTreeNode(root.left,node)||searchTreeNode(root.right,node);
    }

    public static TreeNode findLCABestAnswer(TreeNode root, TreeNode a, TreeNode b) {
        // Add your code below this line. Do not modify any other code.
        if(root == null || root == a || root == b) {
            return root;
        }

        TreeNode rightAncestor = findLCA(root.right, a, b);
        TreeNode leftAncestor = findLCA(root.left, a, b);

        if(rightAncestor!=null && leftAncestor!=null) {
            return root;
        }
        return rightAncestor!=null?rightAncestor:leftAncestor;
        // Add your code above this line. Do not modify any other code.
    }

    public static void main(String[] args) {
        TreeNode head = restoreTree("1,2,3,4,5,6,7,8,9,10,*");
        TreeNode b = new TreeNode(8);
        TreeNode a = new TreeNode(15);
        TreeNode node = findLCABestAnswer(head,a,b);
        if(node!=null) {
            System.out.println(node.data);
        }
    }
}
