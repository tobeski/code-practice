
package com.eltobeski.Random;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class RemoveMinimumParantheses {


    public static String numberParenthesisToBeRemoved(String word){
        Deque<Pair<Integer,Character>> paraStack = new ArrayDeque<>();
        Set<Integer> toRemove = new HashSet<>();
        int remove = 0;

        StringBuilder stringBuilder = new StringBuilder();
        char lastChar = '@';
        char[] newWordArray = word.toCharArray();
        for (int i = 0; i < newWordArray.length; i++) {
            char curr = newWordArray[i];
            if(paraStack.isEmpty() && curr==')')
            {
                toRemove.add(i);
                remove++;
            }
            else if (paraStack.isEmpty() && curr == '(' ){
                paraStack.push(new Pair<>(i,curr));
            }
            else if(curr=='(' && lastChar==')'){
                remove += paraStack.size();
                while (!paraStack.isEmpty()){
                    Pair<Integer,Character> pair = paraStack.pop();
                    toRemove.add(pair.getKey());
                }
                paraStack = new ArrayDeque<>();
                paraStack.push(new Pair<>(i,curr));
            }
            else if(curr=='('){
                paraStack.push(new Pair<>(i,curr));
            }
            else if(curr==')'){
                paraStack.pop();
            }


            if(curr=='('||curr==')'){
                lastChar = curr;
            }

        }
        while (!paraStack.isEmpty()){
            Pair<Integer,Character> pair = paraStack.pop();
            toRemove.add(pair.getKey());
        }
        for (int i = 0; i < word.length(); i++) {
            if(!toRemove.contains(i)){
                stringBuilder.append(newWordArray[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(numberParenthesisToBeRemoved("(a(c()b)"));
    }
}


/*
Have a stack that stores open paranthesis
When a close paranthesis is found count the number of consecutive closed paranthesis
If the number is less than or greater than the number of open , the difference is added to count
i.e Keep popping out of stack until theres another open bracket
If the numb
 */
