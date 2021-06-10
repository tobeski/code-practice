package com.eltobeski.LeetCode;

import sun.jvm.hotspot.utilities.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersIAndII {

    public static Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;

        while (true) {
            int queueSize = queue.size();
            if(queueSize==0)
                break;
            System.out.println("Current level is"+level);
            while (queueSize>0){
                Node node = queue.poll();
                if(queueSize!=1)
                    node.next = queue.peek();
                else
                    node.next = null;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
                queueSize--;
            }
            level++;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        Node node = connect(root);
        int a = 5;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
