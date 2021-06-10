package com.eltobeski.Random;

import com.eltobeski.FireCode.TreeNode;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;
import static com.eltobeski.FireCode.ValidateBSTIteratively.validateBSTItr;

public class FindClosestNumberInBST {

    private static int closestNumberToValueInBST(TreeNode root,int x){
        int[] values = new int[]{root.data,x};
         closestNumberToValueInBSTHelper(root,values);
         return values[0];
    }

    private static void closestNumberToValueInBSTHelper(TreeNode root,int[] values){
        if(root==null)
            return ;
        if(root.data==values[1])
            values[0] = root.data;
       else if(values[1]<root.data)
        {
            if(root.left!=null && values[1]>root.left.data){
              values[0] = compareValues(root.data,root.left.data,values[1]);
              closestNumberToValueInBSTHelper(root.left,values);
            }
            else if(root.left!=null && values[1]<root.left.data) {
                closestNumberToValueInBSTHelper(root.left, values);
            }
            else {
                values[0] = compareValues(root.data,values[0],values[1]);
            }
        }
        else {
            if(root.right!=null && values[1]<root.right.data){
                values[0] = compareValues(root.data,root.right.data,values[1]);
                closestNumberToValueInBSTHelper(root.right,values);
            }
            else if(root.right!=null && values[1]>root.right.data) {
                closestNumberToValueInBSTHelper(root.right, values);
            }
            else {
                values[0] = compareValues(root.data,values[0],values[1]);
            }
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    private static int compareValues(int x,int y,int comparator){
        if(Math.abs(comparator-x)<Math.abs(comparator-y)) {
            return x;
        }
        else {
            return y;
        }
    }

    public static void main(String[] args){
        TreeNode head = restoreTree("10,5,15,2,5,13,22,1,*,*,*,*,14,*,*");
//        TreeNode head = restoreTree("10");

        System.out.println(closestNumberToValueInBST(head,5));
        System.out.println(validateBSTItr(head));
    }
}
