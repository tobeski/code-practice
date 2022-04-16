package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.ListNode;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
       if(head==null||head.next==null)
           return head;
       ListNode newHead = head.next;
       head.next = swapPairs(head.next.next);
       newHead.next = head;
       return newHead;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = swapPairs(head);
        ListNode curr = newHead;
        while (curr!= null){
            System.out.println(curr.data);
            curr=curr.next;
        }
    }
}
