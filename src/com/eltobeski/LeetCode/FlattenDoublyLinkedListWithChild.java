package com.eltobeski.LeetCode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class FlattenDoublyLinkedListWithChild {
    public static Node flatten(Node head) {
        if (head == null)
            return null;

        Deque<Node> nodeDeque = new ArrayDeque<>();
        Node curr = head;
        Node flatNode = new Node();
        Node prevNode = null;
        Node currNode = flatNode;
        nodeDeque.offer(curr);

        while (!nodeDeque.isEmpty()) {
            Node currentNode = nodeDeque.pop();
            currNode.val = currentNode.val;
            currNode.prev = prevNode;
            if (prevNode != null)
                prevNode.next = currNode;

            if (currentNode.next != null) {
                nodeDeque.push(currentNode.next);
                currNode.next = currentNode.next;
            }

            if (currentNode.child != null) {
                nodeDeque.push(currentNode.child);
                currNode.next = currentNode.child;
            }
            prevNode = currNode;
            currNode = new Node();

        }

        return flatNode;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node head1 = new Node(2);
        Node head2 = new Node(3);
        Node head3 = new Node(4);
        Node head4 = new Node(5);
        Node head5 = new Node(6);
        Node head6 = new Node(7);
        Node head7 = new Node(8);
        Node head8 = new Node(9);
        Node head9 = new Node(10);
        Node head10 = new Node(11);
        Node head11 = new Node(12);
        head.next = head1;
        head1.prev = head;
        head1.next = head2;
        head2.prev = head1;
        head2.next = head3;
        head3.prev = head2;
        head3.next = head4;
        head4.prev = head3;
        head4.next = head5;
        head5.prev = head4;
        head5.next = null;
        head2.child = head6;
        head6.next = head7;
        head7.prev = head6;
        head7.next = head8;
        head8.prev = head7;
        head8.next = head9;
        head9.prev = head8;
        head9.next = null;
        head7.child = head10;
        head10.next = head11;
        head11.prev = head10;

        Node flattenedList = flatten(head);
        Node curr = flattenedList;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

//    public void helper(Node head, Node newNode, Queue<Node> nodeQueue,Node prev) {
//        if(prev!=null)
//        {
//            prev.next = newNode;
//        }
//        if(head!=null){
//            newNode.prev = prev;
//            newNode.val = head.val;
//            if(head.child!=null)
//            {
//                helper(head.child);
//            }
//        }
//
//    }


    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(Node prev, Node next) {
            this.prev = prev;
            this.next = next;
        }
    }
}
