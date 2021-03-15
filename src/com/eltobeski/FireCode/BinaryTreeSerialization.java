package com.eltobeski.FireCode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialization {
    public static String serializeTree(TreeNode root){
        if(root==null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.data);
        TreeNode node;

        while(!queue.isEmpty()){
            node = queue.poll();

            if(node.left!=null){
                queue.add(node.left);
                sb.append(","+node.left.data);
            }else{
                sb.append(",*");
            }
            if(node.right!=null){
                queue.add(node.right);
                sb.append(","+node.right.data);
            }else{
                sb.append(",*");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static TreeNode restoreTree(String str){
        if(str==null||str.isEmpty()) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] numbers = str.split(",");
        int index = 0;
        int value = Integer.parseInt(numbers[index]);
        TreeNode root = new TreeNode(value);
        TreeNode curr ;
        queue.add(root);
        while(!queue.isEmpty() && index< numbers.length-1){
            curr = queue.poll();

            index++;
            if(!numbers[index].equals("*")){
                value = Integer.parseInt(numbers[index]);
                curr.left = new TreeNode(value);
                queue.add(curr.left);
            }
            else{
                curr.left = null;
            }
            index++;
            if(!numbers[index].equals("*")){
                value = Integer.parseInt(numbers[index]);
                curr.right = new TreeNode(value);
                queue.add(curr.right);
            }
            else{
                curr.right = null;
            }
        }
        return root;

    }


    public static void main(String[] args){
        TreeNode head = restoreTree("1,2,3,4,5,6,7,*,*,2,*,1,*,1,*");

        System.out.println(serializeTree(head));
    }
}
