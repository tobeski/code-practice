package com.eltobeski.FireCode.RemoveDuplicatesInALinkedList;

import com.eltobeski.FireCode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInALinkedList {
    public ListNode removeDuplicates(ListNode head) {
        Set<Integer> numbers = new HashSet<>();
        if(head==null||head.next==null)
            return head;
        ListNode curr = head.next;
        ListNode prev = head;
        numbers.add(prev.data);

        while(curr!=null){
            if(numbers.contains(curr.data)){

                prev.next = curr.next;
            }else{
                numbers.add(curr.data);
                prev = curr;
            }
            curr = curr.next;

        }


        return head;

    }
}
