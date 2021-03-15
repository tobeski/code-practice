package com.eltobeski.FireCode.InsertNodeAtHeadOfDoublyLinekdList;


import com.eltobeski.FireCode.DoublyLinkedNode;

public class InsertNodeAtHeadOfDoublyLinkedList {
    public DoublyLinkedNode switchHeadOfDoublyLinkedNode(DoublyLinkedNode head, int data){
        DoublyLinkedNode node = new DoublyLinkedNode(data);
        if(head == null){
            return node;
        }
        node.next = head;
        head.prev = node;
        return  node;
    }
}
