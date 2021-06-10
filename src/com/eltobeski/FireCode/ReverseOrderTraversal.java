package com.eltobeski.FireCode;

import java.util.*;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

/*
Using a queue push all values from right to left to a stack
2 Read all values from stack into arraylist

 */
public class ReverseOrderTraversal {
    public static ArrayList<Integer> levelorderRev(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList();
        if (root == null)
            return answer;
        Queue<TreeNode>  treeNodes = new LinkedList<>();
        Deque<Integer> integerStack = new ArrayDeque<>();
        treeNodes.offer(root);

        while (!treeNodes.isEmpty()){
            TreeNode treeNode = treeNodes.poll();
            integerStack.push(treeNode.data);

            if(treeNode.right!=null)
            {
                treeNodes.offer(treeNode.right);
            }
            if(treeNode.left!=null)
            {
                treeNodes.offer(treeNode.left);
            }

        }
        while (!integerStack.isEmpty()){
            answer.add(integerStack.pop());
        }
    return answer;
    }

    public static void main(String[] args) {
        TreeNode head = restoreTree("1,2,3,4,5,6,7");

        System.out.println(levelorderRev(head));
//        System.out.println(Integer.MAX_VALUE);
    }
}
