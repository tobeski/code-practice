package com.eltobeski.FireCode;

public class FindMiddleNode {

    public ListNode findMiddleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        if(head==null || head.next == null){
            return head;
        }

        while ( fast.next != null && fast.next.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;

    }


}
