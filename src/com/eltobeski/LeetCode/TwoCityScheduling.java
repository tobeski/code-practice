package com.eltobeski.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {

        int halfLength = costs.length/2;
        int total = 0;
        Arrays.sort(costs, (o1, o2) -> o1[0]-o1[1]-(o2[0]-o2[1]));
        for(int i = 0;i<halfLength;i++) {
            total += costs[i][0];
        }
        for(int i = halfLength;i<costs.length;i++) {
            total += costs[i][1];
        }
        return total;
    }

    public static void main(String[] args) {
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
        System.out.println(twoCityScheduling.twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
    }
}
