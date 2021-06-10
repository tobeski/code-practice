package com.eltobeski.Codility.MSFTROUND2;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class SecondQuestion {
    public static int solution(String s) {
        int totalOnes = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i)=='1')
                totalOnes++;
        }
        int leftmostOne = s.indexOf('1');
        if(leftmostOne==-1)
            return 0;
        return totalOnes + s.length() - leftmostOne - 1;

    }


    public static int numberOfLevels(String input){
        BigInteger decimalValue = toDecimal(input);
        return performOperation(decimalValue.longValue(),0);
    }

    private static BigInteger toDecimal(String input){
        char[] charArray = input.toCharArray();
        BigInteger total = new BigInteger("0");
        for(int i=0; i< charArray.length; i++){
            if(charArray[i] == 1) {
               total =  total.add(BigInteger.valueOf(((long) Math.pow(2, i))));
            }
        }

        return total;
    }

    private static int performOperation(long data, int totalOperations){
        if(data==0)
            return totalOperations;

        if(data%2 == 0){
            totalOperations++;
            return performOperation(data/2, totalOperations);
        }else{
            totalOperations++;
            return performOperation(data-1, totalOperations);
        }
    }

    public static int minimumSteps(int number){
        Queue<Pair<Integer,Integer>> numbers = new LinkedList<>();
        numbers.offer(new Pair<>(0,number));
        int steps = 0;
        while (!numbers.isEmpty()){
            Pair<Integer,Integer> currPair = numbers.poll();
            if(currPair.getValue().equals(0)){
                steps = currPair.getKey();
                break;
            }
            if(currPair.getValue()%2==0){
                numbers.offer(new Pair<>(currPair.getKey()+1, currPair.getValue()/2));

            }
            else {
                numbers.offer(new Pair<>(currPair.getKey() + 1, currPair.getValue() -1));
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        String s = "";
        for (int i = 0; i < 400000; i++) {
            s+="1";
        }
        System.out.println(numberOfLevels(s));


    }
}
