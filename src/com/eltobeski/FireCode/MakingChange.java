package com.eltobeski.FireCode;

import java.util.*;

public class MakingChange {

    public static int makeChange(int[] coins, int amount) {
        Queue<Integer> integers = new LinkedList<>();
        int answer = 0;
        for (int coin:coins
             ) {
            integers.offer(coin);
        }
        for (int i=0;i< coins.length;i++
             ) {
            Deque<ChangeAmount> integerStack = new ArrayDeque<>();
            integerStack.push(new ChangeAmount(amount-coins[i]));
            while (!integerStack.isEmpty())
            for (int j=i;j< coins.length;j++
            ) {
                if(integerStack.isEmpty())
                    break;
                ChangeAmount changeAmount = integerStack.pop();
                if(changeAmount.remaining==0)
                {
                    answer++;
                    break;
                }
                int newChange = changeAmount.remaining-coins[j];
                if(newChange==0)
                {
                    answer++;
                }
                else if(newChange>0){
                    integerStack.push(new ChangeAmount(newChange));
                }


            }
             integers.poll();
        }




return answer;

    }

    static class ChangeAmount {
        List<Integer> numbers = new ArrayList<>();
        int remaining;
        ChangeAmount(int data) {
            this.remaining = data;
                numbers.add(data);
        }
    }


    public static void main(String[] args) {
        System.out.println(makeChange(new int[]{35,10,5,1},35));
    }
}
