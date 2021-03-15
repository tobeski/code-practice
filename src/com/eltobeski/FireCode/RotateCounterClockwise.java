package com.eltobeski.FireCode;

public class RotateCounterClockwise {
    public static void rotateSquareImageCCW(int[][] matrix) {
        if(matrix.length==0)
            return;

        transpose(matrix);
        flipHorizontal(matrix);


    }

    private static void flipHorizontal(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int temp = 0;

        for(int i= 0;i<rows/2;i++){
            for(int j=0;j<columns;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[rows-1-i][j];
                matrix[rows-1-i][j] = temp;
            }
        }
    }

    public static void transpose(int[][] matrix ){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int temp = 0;

        for(int i= 0;i<rows;i++){
            for(int j=i;j<columns;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
