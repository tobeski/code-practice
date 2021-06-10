package com.eltobeski.FireCode.FindSpiralInMatrix;

import java.util.ArrayList;

public class FindSpiralInMatrix {
    /*
    0   1   2   3
0   1   2   3   4
1   5   6   7   8
2   9   10  11  12
3   13  14  15  16

00 01 02 03 13 23 33 32 31 30 20 10

     */
    public static void main(String[] args) {
        // write your code here
        int[][] arr = new int[3][6];
//        arr[0][0] = 1;
//        arr[0][1] = 2;
//        arr[0][2] = 3;
//        arr[1][2] = 6;
//        arr[2][2] = 9;
//        arr[2][1] = 8;
//        arr[2][0] = 7;
//        arr[1][0] = 4;
//        arr[1][1] = 5;
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[0][3] = 4;
        arr[0][4] = 5;
        arr[0][5] = 6;
        arr[1][0] = 7;
        arr[1][1] = 8;
        arr[1][2] = 9;
        arr[1][3] = 10;
        arr[1][4] = 11;
        arr[1][5] = 12;
        arr[2][0] = 13;
        arr[2][1] = 14;
        arr[2][2] = 15;
        arr[2][3] = 16;
        arr[2][4] = 17;
        arr[2][5] = 18;
        System.out.println(findSpiral(arr));
    }

    public static ArrayList<Integer> findSpiral(int[][] arr) {
        ArrayList<Integer> spiralList = new ArrayList<>();
        int a = 0;    //row
        int b = arr.length-1;   //max row
        int c = arr[0].length-1;    //max column
        int d = 0;      //first column

        while(a<=c && d<=b){
            for(int x = d;x <= c;x++){
                spiralList.add(arr[a][x]);
            }
            a++;
            for(int x = a;x <= b;x++){
                spiralList.add(arr[x][c]);
            }
            c--;
            if(a<=b) {
                for (int x = c; x >= d; x--) {
                    spiralList.add(arr[b][x]);
                }
                b--;
            }
            if(d<=c) {
                for (int x = b; x >= a; x--) {
                    spiralList.add(arr[x][d]);
                }
                d++;
            }
        }
        return spiralList;
    }
}
