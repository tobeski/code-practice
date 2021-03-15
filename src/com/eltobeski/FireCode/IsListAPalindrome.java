package com.eltobeski.FireCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IsListAPalindrome {

    public Boolean isListPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null || head.next == null)
            return true;

        ListNode curr = head;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }

        int len = list.size();
        int start = 0;
        int end = len - 1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end)))
                return false;
            start++;
            end--;
        }

        return true;

    }

    public Boolean isListPalindromeBetterSpaceCompSolution(ListNode head) {
        if(head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        ListNode curr = head;
        while(slow != null) {
            if(slow.data != curr.data) {
                return false;
            }
            curr = curr.next;
            slow = slow.next;
        }

        return true;



    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


}
