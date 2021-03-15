package com.eltobeski.FireCode;

public class DeleterCircularLinkedListAtTail {
    public ListNode deleteAtTail(ListNode head) {

        if(head==null||head.next==null)
            return null;
        ListNode node = head;
        ListNode fastNode = head.next;

        while(true){
            if(fastNode.next==head) {
                node.next = fastNode.next;
                break;
            }
            node=node.next;
            fastNode = fastNode.next;
        }
        return head;
    }
}
