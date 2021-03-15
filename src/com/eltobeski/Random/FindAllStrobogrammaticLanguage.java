package com.eltobeski.Random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindAllStrobogrammaticLanguage {
    private List<String> generateStrobogrammaticNumbers(int numberOfDigits){
        List<String> answer = new ArrayList<>();
        if(numberOfDigits==0) return answer;
        boolean odd = numberOfDigits%2==1;
        int halfSize;
        if(odd) {
            halfSize = (numberOfDigits / 2) + 1;
        }
        else {
            halfSize = numberOfDigits/2;
        }
        Queue<Character[]> numbersQueue = new LinkedList<>();
        Character[] x = new Character[]{'0','1','6','8','9'};

        for (char c:
             x) {
            Character[] ch = new Character[numberOfDigits];

            if(c=='6'){
                ch[0] = '6'; ch[numberOfDigits-1] = '9';
                numbersQueue.offer(ch);
            }
            else if(c=='9'){
                ch[0] = '9'; ch[numberOfDigits-1] = '6';
                numbersQueue.offer(ch);
            }
            else {
                ch[0] = 'c'; ch[numberOfDigits-1] = 'c';
            }
            numbersQueue.offer(ch);
        }


        while (!numbersQueue.isEmpty()){
            Character[] polled = numbersQueue.poll();

        }

        return answer;
    }

    private static String reverseString(String s){
        int mid = s.length()/2;
        StringBuilder sb = new StringBuilder(s);
        for(int i = mid-1; i>=0;i--){
            if(s.charAt(i)!=6 && s.charAt(i)!=9){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)=='6'){
                sb.append('9');
            }
            else if(s.charAt(i)=='9'){
                sb.append('6');
            }
        }
        return "";
    }

    public class Strobosides{
        char[] chars;
        int size;


    }
    public static void main(String[] args){

    }
}
