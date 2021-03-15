package com.eltobeski.FireCode;

import java.util.LinkedList;
import java.util.Queue;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class ValidateBSTIteratively {
    public static boolean validateBSTItr(TreeNode root) {
        Queue<BoundaryNode> boundaryQueue = new LinkedList<>();
        TreeNode curr = root;
        if(curr.left==null && curr.right==null) return  true;
        boundaryQueue.offer(new BoundaryNode(Integer.MIN_VALUE,curr,Integer.MAX_VALUE));
        while(!boundaryQueue.isEmpty()){
            BoundaryNode bn = boundaryQueue.poll();
            curr = bn.treeNode;
            if(bn.lowerBound>curr.data || bn.upperBound<curr.data)
                return false;
            if(curr.left!=null)
                boundaryQueue.offer(new BoundaryNode(bn.lowerBound,curr.left,curr.data));
            if(curr.right!=null)
                boundaryQueue.offer(new BoundaryNode(curr.data,curr.right,bn.upperBound));

        }
        return true;

    }

    public static class BoundaryNode{
        int lowerBound;
        TreeNode treeNode;
        int upperBound;

        public  BoundaryNode(int lowerBound,TreeNode treeNode,int upperBound){
            this.lowerBound = lowerBound;
            this.treeNode = treeNode;
            this.upperBound = upperBound;
        }

    }
    public static void main(String[] args){
        TreeNode head = restoreTree("2147483647");

        System.out.println(validateBSTItr(head));
        System.out.println(Integer.MAX_VALUE);
    }
}
