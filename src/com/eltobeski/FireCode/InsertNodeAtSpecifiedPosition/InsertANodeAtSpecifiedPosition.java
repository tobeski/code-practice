package com.eltobeski.FireCode.InsertNodeAtSpecifiedPosition;

import com.eltobeski.FireCode.ListNode;

public class InsertANodeAtSpecifiedPosition {
    public ListNode insertAtPosition(ListNode head, int data, int pos) {
        ListNode node = new ListNode(data);

        if (head == null)
            return node;
        ListNode curr = head;

        if (pos == 1) {
            node.next = head;
            return node;
        }

        int current = 2;

        while (curr != null && curr.next != null) {
            if (pos == current) {
                node.next = curr.next;
                curr.next = node;
                return head;
            }
            current++;
            curr = curr.next;
        }
        curr.next = node;
        return head;


    }
}
