package com.eltobeski.FireCode;

public class DeleteTail {
    public ListNode deleteAtTail(ListNode head) {
        if(head==null||head.next == null){
            return null;
        }

        ListNode curr = head;
        while(curr != null){
            if(curr.next.next==null)
                curr.next = null;
            curr = curr.next;
        }

        return head;
    }
}
