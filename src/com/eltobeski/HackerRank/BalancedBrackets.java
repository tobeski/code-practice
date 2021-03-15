package com.eltobeski.HackerRank;

import java.util.Stack;

public class BalancedBrackets {
    static String isBalanced(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' )
                stk.push(')');
            if(s.charAt(i)=='[')
                stk.push(']');
            if(s.charAt(i)=='{')
                stk.push('}');

            if(s.charAt(i)=='}' || s.charAt(i)==')' || s.charAt(i)==']')
            {
                if(stk.isEmpty())
                    return "NO";
                if(stk.peek()==s.charAt(i))
                    stk.pop();
                else return "NO";
            }
        }
        if(stk.empty())
            return "YES";
        else
            return "NO";




    }

    public static void main(String args[]){
        System.out.println(isBalanced("([[]]]"));
    }
}
