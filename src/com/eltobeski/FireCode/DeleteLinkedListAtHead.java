package com.eltobeski.FireCode;

public class DeleteLinkedListAtHead {
    public ListNode deleteAtHead(ListNode head) {

        if(head == null||head.next == null) return null;

        ListNode temp = head.next;
        head.next = null;
        head = temp;
        return head;

    }
}
