package com.eltobeski.Random;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class OneDimensionCandyCrush {
    public  static String crushString(String input){
        if(input==null||input.length()<3)
            return input;
        Stack<Character> stack = new Stack<>();
        Stack<Integer> occurences =  new Stack<>();
        stack.push(input.charAt(0));
        occurences.push(1);
        for (int i = 1; i < input.length();i++) {
            Character c = input.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
                occurences.push(1);
            }
            else if(!c.equals(stack.peek()) && occurences.peek()>=3){
                stack.pop();
                occurences.pop();
                i--;
            }
            else if(c.equals(stack.peek())){
                int count = occurences.pop();
                occurences.push(count+1);
            }
            else{
                occurences.push(1);
                stack.push(c);
            }


        }
        if(occurences.peek()>=3){
            stack.pop();
            occurences.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            char ch = stack.pop();
            int count = occurences.pop();
            while (count>0){
                sb.append(ch);
                count--;
            }
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(crushString("ABBCCCCCCCABA"));
    }
}
