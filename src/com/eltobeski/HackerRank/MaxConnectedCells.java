package com.eltobeski.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class MaxConnectedCells {

    static boolean[][] found;

    static List<List<Integer>> actualGrid;

    public static int maxRegion(List<List<Integer>> grid) {
        // Write your code here
        actualGrid = new ArrayList<>(grid);
        int[] ans = new int[1];
        int[] connections = new int[1];
        found = new boolean[grid.size()][grid.get(0).size()];
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (actualGrid.get(i).get(j) == 1 && !found[i][j]) {
                    connections[0] = 1;
                    maxRegionHelper(i, j, ans, connections);
                }
            }
        }

        return ans[0];
    }

    public static void maxRegionHelper(int i, int j, int[] max, int[] connections) {
        boolean canLeft = j - 1 >= 0;
        boolean canRight = j + 1 < actualGrid.get(i).size();
        boolean canUp = i - 1 >= 0;
        boolean canDown = i + 1 < actualGrid.size();
        found[i][j] = true;
        max[0] = Math.max(max[0], connections[0]);


        if (canLeft && actualGrid.get(i).get(j - 1) == 1 && !found[i][j - 1]) {
            connections[0]++;
            max[0] = Math.max(max[0], connections[0]);
            maxRegionHelper(i, j - 1, max, connections);
        }if (canLeft && canUp && actualGrid.get(i-1).get(j - 1) == 1 && !found[i-1][j - 1]) {
            connections[0]++;
            max[0] = Math.max(max[0], connections[0]);
            maxRegionHelper(i-1, j - 1, max, connections);
        }
        if (canRight && actualGrid.get(i).get(j + 1) == 1 && !found[i][j + 1]) {
            connections[0]++;
            max[0] = Math.max(max[0], connections[0]);
            maxRegionHelper(i, j + 1, max, connections);
        }if (canRight && canUp && actualGrid.get(i-1).get(j + 1) == 1 && !found[i-1][j + 1]) {
            connections[0]++;
            max[0] = Math.max(max[0], connections[0]);
            maxRegionHelper(i-1, j + 1, max, connections);
        }
        if (canUp && actualGrid.get(i - 1).get(j) == 1 && !found[i - 1][j]) {
            connections[0]++;
            max[0] = Math.max(max[0], connections[0]);
            maxRegionHelper(i - 1, j, max, connections);
        }
        if (canDown && actualGrid.get(i + 1).get(j) == 1 && !found[i + 1][j]) {
            connections[0]++;
            max[0] = Math.max(max[0], connections[0]);
            maxRegionHelper(i + 1, j, max, connections);
        }
        if (canDown && canLeft && actualGrid.get(i + 1).get(j-1) == 1 && !found[i + 1][j-1]) {
            connections[0]++;
            max[0] = Math.max(max[0], connections[0]);
            maxRegionHelper(i + 1, j-1, max, connections);
        }if (canDown && canRight && actualGrid.get(i + 1).get(j+1) == 1 && !found[i + 1][j+1]) {
            connections[0]++;
            max[0] = Math.max(max[0], connections[0]);
            maxRegionHelper(i + 1, j+1, max, connections);
        }

//        found[i][j] =false;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(0);
        row.add(0);
        row.add(1);
        row.add(0);
        row.add(1);
        row.add(0);
        row.add(0);
        grid.add(row);
        List<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(0);
        row2.add(0);
        row2.add(0);
        row2.add(0);
        row2.add(0);
        row2.add(0);
        row2.add(1);
        grid.add(row2);
        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(0);
        row3.add(1);
        row3.add(0);
        row3.add(1);
        row3.add(0);
        row3.add(0);
        row3.add(0);
        grid.add(row3);
        List<Integer> row4 = new ArrayList<>();
        row4.add(0);
        row4.add(0);
        row4.add(0);
        row4.add(0);
        row4.add(0);
        row4.add(0);
        row4.add(1);
        row4.add(0);
        grid.add(row4);
        List<Integer> row5 = new ArrayList<>();
        row5.add(1);
        row5.add(0);
        row5.add(0);
        row5.add(1);
        row5.add(0);
        row5.add(0);
        row5.add(0);
        row5.add(0);
        grid.add(row5);List<Integer> row6 = new ArrayList<>();
        row6.add(0);
        row6.add(0);
        row6.add(0);
        row6.add(0);
        row6.add(0);
        row6.add(0);
        row6.add(0);
        row6.add(1);
        grid.add(row6);
        List<Integer> row7 = new ArrayList<>();
        row7.add(0);
        row7.add(1);
        row7.add(0);
        row7.add(0);
        row7.add(0);
        row7.add(1);
        row7.add(0);
        row7.add(0);
        grid.add(row7);
        System.out.println(maxRegion(grid));
    }
}
