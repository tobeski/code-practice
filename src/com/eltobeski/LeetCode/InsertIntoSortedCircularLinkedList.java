package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.ListNode;

public class InsertIntoSortedCircularLinkedList {
    public ListNode insert(ListNode head, int insertVal) {
        ListNode newListNode = new ListNode(insertVal);
        if(head==null) {
            head = newListNode;
            head.next = head;
        }
        ListNode node = head;
        ListNode slowNode = node;
        node = node.next;

        while(node != null){

            if (node.data < slowNode.data && (insertVal >= slowNode.data || insertVal <= node.data)) break;

            if (insertVal >= slowNode.data && insertVal <= node.data) break;


            slowNode = node;
            node = slowNode.next;

            if (slowNode == head) break;

        }
        slowNode.next = newListNode;
        newListNode.next = node;
        return head;

    }
}
