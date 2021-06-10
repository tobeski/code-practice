package com.eltobeski.LeetCode;

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List<int[]> finalList = new ArrayList<>();
        Arrays.sort(intervals,(o1, o2) ->{
            if(o1[0]==o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if(nextInterval[0]<= currentInterval[1])
                currentInterval= new int[]{currentInterval[0],Math.max(currentInterval[1],nextInterval[1])};
            else {
                finalList.add(currentInterval);
                currentInterval= new int[]{nextInterval[0],nextInterval[1]};

            }
        }
        finalList.add(currentInterval);
        int [][] answers = new int[finalList.size()][];
        for (int i=0;i<finalList.size();i++
             ) {
            answers[i] = finalList.get(i);
        }
        return  answers;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] answers = merge(intervals);
        for (int[] array:answers
             ) {

            System.out.println(Arrays.toString(array));
        }
    }
}
