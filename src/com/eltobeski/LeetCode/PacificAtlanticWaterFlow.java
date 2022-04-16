package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] found = new boolean[heights.length][heights[0].length];
        boolean[] oceans = new boolean[2];
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                pacificAtlanticHelper(heights, i, j, oceans, found);
                if (oceans[0] && oceans[1]) {
                    List<Integer> array = new ArrayList<>();
                    array.add(i);
                    array.add(j);
                    answer.add(array);
                }
                found = new boolean[heights.length][heights[0].length];
                oceans = new boolean[2];
            }
        }
        return answer;

    }


    private static void pacificAtlanticHelper(int[][] heights, int i, int j, boolean[] oceans, boolean[][] found) {
        if (i == 0 || j == 0) {
            oceans[0] = true;
        }
        if (i == heights.length - 1 || j == heights.length - 1) {
            oceans[1] = true;
        }
        if (oceans[0] && oceans[1])
            return;
        if (!found[i][j]) {
            found[i][j] = true;
            if (i - 1 >= 0 && heights[i - 1][j] <= heights[i][j])
                pacificAtlanticHelper(heights, i - 1, j, oceans, found);
            if (i+1  <= heights.length-1 && heights[i + 1][j] <= heights[i][j])
                pacificAtlanticHelper(heights, i + 1, j, oceans, found);
            if(j-1>=0&&heights[i][j-1]<=heights[i][j])
                pacificAtlanticHelper(heights, i, j - 1, oceans, found);
            if(j+1<= heights.length-1&&heights[i][j+1]<=heights[i][j])
                pacificAtlanticHelper(heights, i, j + 1, oceans, found);
        }


    }


    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
    }
}
