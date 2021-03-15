package com.eltobeski.FireCode;

public class InsertNodeAtLinkedListHead {
    public ListNode insertAtHead(ListNode head, int data) {

        ListNode newHead = new ListNode(data);
        newHead.next = head;
        return newHead;



    }

    class ListNode {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }
}
