package com.eltobeski.FireCode;

import java.util.HashSet;
import java.util.Set;

public class DeleteCircularLinkedListAtHead {
    public ListNode deleteAtHead(ListNode head) {
        if (head == null || head.next == head) {
            return null;
        }
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }

    public ListNode deleteAtHeadMine(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        set.add(node);


        while(node!= null){
            if(node.next==node)
                return null;
            if(set.contains(node.next)){
                node.next = node.next.next;
                return head.next;
            }

            node = node.next;
            set.add(node);
        }

        return head;


    }
}
