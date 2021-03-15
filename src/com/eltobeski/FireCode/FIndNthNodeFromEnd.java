package com.eltobeski.FireCode;

public class FIndNthNodeFromEnd {
    public static ListNode FindNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        int position = 0;
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        int counter = length - n;
        node = head;
        while (node != null) {
            if (counter == position) {
                return node;
            }
            position++;
            node = node.next;
        }
        return null;
    }
}
