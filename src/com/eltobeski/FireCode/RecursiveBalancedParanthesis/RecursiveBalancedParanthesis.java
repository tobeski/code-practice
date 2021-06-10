package com.eltobeski.FireCode.RecursiveBalancedParanthesis;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecursiveBalancedParanthesis {

    static Deque<Character> deque = new ArrayDeque<>();

    public static boolean isBalanced(String input) {
        if (input == null || input.isEmpty())
            return true;
        int length = input.length();
        if (length % 2 != 0)
            return false;
        char firstChar = input.charAt(0);
        if (firstChar == '[' || firstChar == '{' || firstChar == '(') {
            deque.push(firstChar);
            return isBalancedHelper(input.substring(1));
        }
        return false;
    }

    public static boolean isBalancedHelper(String input) {
        if (input.isEmpty() && deque.isEmpty())
            return true;

        char firstChar = input.charAt(0);
        if (firstChar == '[' || firstChar == '{' || firstChar == '(') {
            deque.push(firstChar);
            return isBalancedHelper(input.substring(1));
        }
        if (deque.isEmpty())
            return false;
        char poppedChar = deque.pop();

        if ((firstChar == ']' && poppedChar == '[')
                || (firstChar == '}' && poppedChar == '{')
                || (firstChar == ')' && poppedChar == '('))
            return isBalancedHelper(input.substring(1));
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("[](){}"));
    }

}
