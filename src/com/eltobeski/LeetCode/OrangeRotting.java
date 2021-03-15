package com.eltobeski.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class OrangeRotting {
    public  static int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int hours = 0;
        for(int i = 0; i<row;i++){
            for(int j=0; j<col;j++){
                if(grid[i][j] == 2){
                    rotten.offer(new int[]{i,j,0});
                }
            }
        }

        while (!rotten.isEmpty()){
            int[] curr = rotten.poll();
            int r = curr[0];
            int c = curr[1];
            hours = curr[2];

            if(r+1<row && grid[r+1][c] == 1){
                grid[r+1][c] = 2;
                rotten.offer(new int[]{r+1,c,hours+1});
            }
            if(r-1>=0 && grid[r-1][c] == 1){
                grid[r-1][c] = 2;
                rotten.offer(new int[]{r-1,c,hours+1});
            }if(c+1<col && grid[r][c+1] == 1){
                grid[r][c+1] = 2;
                rotten.offer(new int[]{r,c+1,hours+1});
            }if(c-1>=0 && grid[r][c-1] == 1){
                grid[r][c-1] = 2;
                rotten.offer(new int[]{r,c-1,hours+1});
            }
        }
        for(int i = 0; i<row;i++){
            for(int j=0; j<col;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return hours;
    }

    public static void main (String [] args){
        int [][] grid = new int[][]{{1,2}};

    }
}
