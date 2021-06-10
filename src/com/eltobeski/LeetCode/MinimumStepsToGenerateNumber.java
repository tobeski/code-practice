package com.eltobeski.LeetCode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MinimumStepsToGenerateNumber {

    public int minimumSteps(int number){
        Queue<Pair<Integer,Integer>> numbers = new LinkedList<>();
        numbers.offer(new Pair<>(0,1));
        int steps = 0;
        while (!numbers.isEmpty()){
            Pair<Integer,Integer> currPair = numbers.poll();
            if(currPair.getValue()==0)
                continue;
            if(currPair.getValue().equals(number)){
                steps = currPair.getKey();
                break;
            }
            numbers.offer(new Pair<>(currPair.getKey()+1, currPair.getValue()*2));
            numbers.offer(new Pair<>(currPair.getKey()+1, currPair.getValue()/3));

        }
        return steps;
    }

    public static void main(String[] args) {
        MinimumStepsToGenerateNumber min = new MinimumStepsToGenerateNumber();
        System.out.println(min.minimumSteps(3));

    }
}
