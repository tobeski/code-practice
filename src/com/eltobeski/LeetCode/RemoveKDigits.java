package com.eltobeski.LeetCode;

import java.util.ArrayDeque;
import java.util.Stack;

public class RemoveKDigits {
//java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '62048782DA0E51408696C77A6E4CDDF1CA975313AF42C7E93B35A1083ED46278' for key 'card_requests.card_hashed_pan_uindex'
    /*
    Start from left
    While you still have digits to remove
    if(left>right)
    remove left
    if right > left keep going right until there is a change in
    After words if theres still digits remainin keep removing from left until it's out
     */
    public static String removeKdigits(String num, int k) {
        if (k == 0)
            return num;
        Stack<Character> sb = new Stack<>();
        sb.push(num.charAt(0));


        for (int i = 1; i < num.length(); i++) {
            if (k > 0) {


                if (sb.isEmpty()) {
                    if(num.charAt(i)!='0')
                    sb.push(num.charAt(i));
                }
                else {
                    if (num.charAt(i) >= sb.peek()) {
                        sb.push(num.charAt(i));
                    } else {
                        sb.pop();
                        i--;
                        k--;
                    }
                }
            } else {
                if (!sb.isEmpty() || num.charAt(i) != '0') {
                    sb.push(num.charAt(i));
                }
            }
        }
        if (k > sb.size())
            return "0";

        StringBuilder word = new StringBuilder();
        while (!sb.isEmpty()) {
            if (k > 0) {
                sb.pop();
                k--;
                continue;
            }
            word.append(sb.pop());
        }
        if(word.length()==0)
            return "0";
        return word.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("10200", 1));
    }
}
