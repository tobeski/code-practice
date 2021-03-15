package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int sum = 0;
        int leftNumber = 0;
        int rightNumber = 0;
        int carry = 0;
        ListNode newList = null;


        while (l1!=null){
            s1.push(l1.data);
            l1 = l1.next;
        } while (l2!=null){
            s2.push(l2.data);
            l2 = l2.next;
        }
        while (!s1.isEmpty()||!s2.isEmpty()||carry!=0) {
            if (!s1.isEmpty())
                leftNumber = s1.pop();
            if (!s2.isEmpty())
                rightNumber = s2.pop();
            sum = leftNumber + rightNumber + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            else carry=0;
            ListNode newNode = new ListNode(sum);
            newNode.next = newList;
            newList = newNode;
            leftNumber = 0;
            rightNumber = 0;
        }
        return newList;
    }

    public static void main(String[] args){
        ListNode a1 = new ListNode(6);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(3);
        b1.next = b2;
        b2.next = b3;

        ListNode answer = addTwoNumbers(a1,b1);
        answer.next = answer;
    }
}
