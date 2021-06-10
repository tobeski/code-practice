package com.eltobeski.FireCode;

/*

1 - 2 - 3

3.next 0
3

2,3.next =2
2.next = null

1,2.next = 1
1.next = null

1 2 3
1,2  ---- 2.next - 1 1.next - null
2,3 ------ 3.next - 2 .next
3,null
newhead = 3
 */

public class ReverseLinkedListRecursion {

    public static ListNode reverseLinkedListRecursion(ListNode head) {
        if (head == null || head.next == null)
            return head;

       return reverseLinkedListRecursionHelper(head,head.next );
    }

    public  static ListNode reverseLinkedListRecursionHelper(ListNode head, ListNode sNode) {

        if(sNode==null)
            return head;

        ListNode newHead =   reverseLinkedListRecursionHelper(sNode,head.next);
//        ListNode temp = sNode.next;
        sNode.next = head;
        head.next = null;

        return newHead;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode newHead = reverseLinkedListRecursion(head);
        System.out.println(newHead.data);
        System.out.println(newHead.next.data);
        System.out.println(newHead.next.next.data);

        newHead = newHead;
    }
}
