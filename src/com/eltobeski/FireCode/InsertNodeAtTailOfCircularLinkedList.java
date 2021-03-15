package com.eltobeski.FireCode;

public class InsertNodeAtTailOfCircularLinkedList {
    public ListNode insertAtTail(ListNode head, int data) {
        ListNode tail = new ListNode(data);
        tail.next = tail;
        if(head == null) return tail;
        ListNode slowNode = head;
        ListNode fastNode = head.next;


        while(slowNode != fastNode){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        slowNode.next = tail;
        tail.next = head;
        return head;




    }
}
