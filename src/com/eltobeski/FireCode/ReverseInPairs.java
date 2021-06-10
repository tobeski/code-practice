package com.eltobeski.FireCode;

public class ReverseInPairs {
    public static ListNode reverseInPairs(ListNode head) {
        if(head==null)
            return null;
        return reverseInPairsHelper(head,head.next);


    }

    public static ListNode reverseInPairsHelper(ListNode head,ListNode second) {
            if(second ==null)
                return head;

            int tempData = head.data;
            head.data = second.data;
            second.data = tempData;

            if(second.next!=null)
                second.next = reverseInPairsHelper(second.next, second.next.next);

            return head;

    }
    public ListNode reverseInPairsIteration(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode curr = head;
        ListNode fast = head.next;

        while(curr!=null && fast!= null){
            int temp = curr.data;
            curr.data = fast.data;
            fast.data = temp;
            if(fast.next==null)
            {
                break;
            }
            else{
                curr = fast.next;
            }
            if(curr.next==null)
            {
                break;
            }
            else{
                fast = curr.next;
            }
        }

        return head;







    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(reverseInPairs(node).data);
        node.data=node.next.data;

    }
}
