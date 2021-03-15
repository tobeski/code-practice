package com.eltobeski.FireCode;

import java.util.Arrays;

public class FlipItVertical {
    public static void flipItVerticalAxis(int[][] matrix) {
        int r = matrix.length - 1, c = matrix[0].length - 1;
        int temp = 0;
        for(int i = 0; i <= r; i++){
            for(int j = 0; j <= c/2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][c - j];
                matrix[i][c - j] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[][] mat = new int[][]{{0,1,2},{3,4,5},{6,7,8}};
flipItVerticalAxis(mat);
        System.out.println(mat);
    }
}
