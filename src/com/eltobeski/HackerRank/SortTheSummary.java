package com.eltobeski.HackerRank;

import java.util.*;

public class SortTheSummary {

    static void sort(int[] numbers) {
        Map<Integer, Integer> numCounts = numCounter(numbers);
        System.out.println(Arrays.deepToString(sortedNumbers(numCounts)));
    }

    static Map<Integer, Integer> numCounter(int[] numbers) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num : numbers
        ) {
            int freq = maps.getOrDefault(num, 0);
            maps.put(num, freq + 1);
        }
        return maps;
    }

    static int[][] sortedNumbers(Map<Integer, Integer> numMap) {
        int[][] array = new int[numMap.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            array[i][0] = entry.getKey();
            array[i][1] = entry.getValue();
            i++;
        }
        Arrays.sort(array, (o1, o2) -> {
            if (o1[0] == o2[0] && o1[1] == o2[1])
                return 0;
            if (o1[1] < o2[1] || (o1[1] == o2[1] && o1[0] < o2[0]))
                return 1;
            return -1;
        });

        return array;
    }


    public static void main(String[] args) {

        sort(new int[]{3, 3, 1, 2, 1, 6, 7, 5, 6, 7, 7, 7, 7, 7, 3, 1, 2, 1, 2, 2});
    }



}
