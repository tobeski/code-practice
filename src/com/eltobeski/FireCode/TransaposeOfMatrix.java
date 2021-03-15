package com.eltobeski.FireCode;

public class TransaposeOfMatrix {

    public static void transposeMatrix(int[][] matrix) {
        int temp = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i = 0; i<rows;i++){
            for (int j=i; j<columns ; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args){
        int [][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(-1%2);
        transposeMatrix(array);
//        System.out.println(array);
    }
}
