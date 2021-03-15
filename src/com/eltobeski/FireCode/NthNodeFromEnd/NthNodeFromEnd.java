package com.eltobeski.FireCode.NthNodeFromEnd;

import com.eltobeski.FireCode.ListNode;

public class NthNodeFromEnd {
    public ListNode findNthNodeFromEnd(ListNode head, int n) {

        if(head==null)
            return head;

        int size =0;
        ListNode curr = head;

        while(curr != null){
            size++;
            curr = curr.next;
        }
        curr = head;
        int position = size - n;
        if(position<0){
            return null;
        }
        for(int i= 0;i<size;i++){
            if(position==i){
                break;
            }
            curr = curr.next;

        }
        return curr;
    }
}
