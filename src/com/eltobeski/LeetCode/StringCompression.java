package com.eltobeski.LeetCode;


import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringCompression {
    public static int compress(char[] chars) {
        Deque<Pair<Character,String>> deque = new ArrayDeque<>();
        deque.push(new Pair<>(chars[0],1+""));
        for (int i = 1; i < chars.length ; i++) {
            if(chars[i]==deque.peek().getKey()){
                Pair<Character,String> curr = deque.pop();
                int total = Integer.valueOf(curr.getValue());
                total++;
                deque.push(new Pair<>(curr.getKey(),total+""));
            }
            else {
                deque.push(new Pair<>(chars[i],1+""));
            }
        }
        int i = 0;
        while (!deque.isEmpty()){
            Pair<Character,String> curr = deque.pollLast();
            chars[i] = curr.getKey();
            i++;
            String numberString = curr.getValue();
            if(numberString.equals("1"))
                continue;
            if(numberString.length()==1){
                chars[i]=numberString.charAt(0);
                i++;
                continue;
            }
            while (numberString.length()>0){
                chars[i]=numberString.charAt(0);
                i++;
                numberString=numberString.substring(1);
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }
}
