package com.eltobeski.FireCode;

public class DeleteLinkedListAtMiddle {
    public ListNode deleteAtMiddle(ListNode head, int position) {
        if(head == null)
            return null;
        if(position==1 )
            return head.next;
        ListNode currentNode = head;
        ListNode fastNode = currentNode;
        int counter = position;
        while(counter > 2){
            currentNode = currentNode.next;
            if(currentNode==null)
                return head;
            fastNode = currentNode.next;
            counter--;
        }
        if(fastNode!=null && fastNode.next!=null){
            currentNode.next = fastNode.next;
        }
        else{
            currentNode.next = null;
        }
        return head;
    }
}
