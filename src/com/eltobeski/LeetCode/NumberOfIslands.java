package com.eltobeski.LeetCode;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // sink and increment islands
                    sink(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private static void sink(char[][] grid, int i, int j) {
        // out of bounds
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0'; // sink

        // travel in all 4 directions
        sink(grid, i+1, j);
        sink(grid, i-1, j);
        sink(grid, i, j+1);
        sink(grid, i, j-1);
    }
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }

}
