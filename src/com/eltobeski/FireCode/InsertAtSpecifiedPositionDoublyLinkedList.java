package com.eltobeski.FireCode;

public class InsertAtSpecifiedPositionDoublyLinkedList {
    public static DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {
        if(head == null && pos > 1) return null;
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        if(head==null && pos == 1) return newNode;
        else if (head != null && pos ==1) {

            newNode.next = head;
            head.prev = newNode;
            return newNode;

        }
        int counter = 1;
        DoublyLinkedNode prev = null;
        DoublyLinkedNode curr = head;

        while(curr != null && counter <= pos){
            if(counter==pos){
                newNode.prev = prev;
                if(prev!=null) {prev.next = newNode;}
                newNode.next = curr;
                curr.prev = newNode;
            }
            prev = curr;
            curr = curr.next;
            counter++;
        }
        if(curr==null && counter == pos){
            if(prev!=null) {prev.next = newNode;}
            newNode.prev = prev;
        }
        return head;



    }

    public static void main(String[] args){
//        1<=>2<=>3<=>4
        DoublyLinkedNode node = new DoublyLinkedNode(1);
        node.next = new DoublyLinkedNode(2);
        node.next.prev = node;
        node.next.next = new DoublyLinkedNode(3);
        node.next.next.prev = node.next;


        insertAtPos(node,4,4);
        node = node;
    }
}
