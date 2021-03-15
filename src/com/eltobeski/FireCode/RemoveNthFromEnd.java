package com.eltobeski.FireCode;

import java.util.List;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        int length = 0;
        int position = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        int counter = length - n;
        node = head;
        ListNode slowNode = node;
        while (node != null) {
            if (counter == position) {
                if (slowNode != node) {
                    slowNode.next = node.next;
                    break;
                } else {
                    return head.next;
                }
            }
            position++;
            slowNode = node;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        1<=>2<=>3<=>4
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);


        node = removeNthFromEnd(node, 1);
        node = node;
    }
}
