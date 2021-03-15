package com.eltobeski.FireCode;

import java.util.LinkedList;
import java.util.Queue;

public class DecompressTree {
    public static TreeNode decompressTree(String str){
        if(str==null||str.isEmpty()) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] numbers = str.split(",");
        int index = 0;
        if(numbers[0]=="*") return null;
        int value = Integer.parseInt(numbers[index]);
        TreeNode root = new TreeNode(value);
        TreeNode curr ;
        queue.add(root);

        while(!queue.isEmpty()){
            curr = queue.poll();
            if(curr==null ){
                index= index+2;
                continue;
            }
            index++;
            if(index>=numbers.length) break;
            if(!numbers[index].equals("*")){
                value = Integer.parseInt(numbers[index]);
                curr.left = new TreeNode(value);
            }
            else{
                curr.left = null;

            }
            queue.add(curr.left);
            index++;
            if(index>=numbers.length) break;
            if(!numbers[index].equals("*")){
                value = Integer.parseInt(numbers[index]);
                curr.right = new TreeNode(value);
            }
            else{
                curr.right = null;
            }
            queue.add(curr.right);

        }
        return root;
    }
    public static void main(String[] args){
        TreeNode head = decompressTree("1,2,3,4,5,6,7,*,*,2,*,1,*,1,*");

    }
}
