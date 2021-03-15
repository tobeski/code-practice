package com.eltobeski.Random;



public class ReverseWordFromListNode {
    public static ListNode reverseWord(ListNode root){
        if(root==null||root.next==null) return root;

        ListNode reverseHead = new ListNode(root.data);
        ListNode node = root;


        while (node.next != null){
            node = node.next;
            ListNode currRev = new ListNode(node.data);
            currRev.next = reverseHead;
            reverseHead = currRev;
        }

        return  reverseHead;
    }
    public static void main(String[] args){
        ListNode root = new ListNode('o');

        ListNode f = new ListNode('f');
        root.next = f;
        ListNode u = new ListNode('u');
        f.next = u;
        ListNode r = new ListNode('r');
        u.next = r;
        ListNode e = new ListNode('e');
        r.next = e;

        ListNode origin = root;

        System.out.print(origin.data);
        while (origin.next!=null){
            origin = origin.next;
            System.out.print(origin.data);
        }

        ListNode reverseHead = reverseWord(root);
        ListNode node = reverseHead;
        System.out.println("");
        System.out.print(node.data);
        while (node.next!=null){
            node = node.next;
            System.out.print(node.data);
        }
    }


     static class ListNode {
        char data;
        ListNode next;
        ListNode(char data) { this.data = data; }
    }
}
