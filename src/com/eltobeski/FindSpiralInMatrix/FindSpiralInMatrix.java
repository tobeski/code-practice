package com.eltobeski.FindSpiralInMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        int[][] arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][2] = 7;
        arr[2][2] = 11;
        arr[2][1] = 10;
        arr[2][0] = 9;
        arr[1][0] = 5;
        arr[1][1] = 6;
        System.out.println(findSpiral(arr));
    }

    public static ArrayList<Integer> findSpiral(int[][] arr) {
        ArrayList<Integer> spiralList = new ArrayList<>();
        int a = 0;
        int b = arr.length-1;
        int c = arr.length-1;
        int d = 0;

        while(spiralList.size() < (arr.length * arr[0].length)){
            for(int x = d;x <= b;x++){
                spiralList.add(arr[a][x]);
            }
            a++;
            for(int x = a;x <= c;x++){
                spiralList.add(arr[x][b]);
            }
            b--;
            for(int x = b;x >= d;x--){
                spiralList.add(arr[c][x]);
            }
            c--;
            for(int x = c;x >= a;x--){
                spiralList.add(arr[x][d]);
            }
            d++;

        }
        return spiralList;
    }
}
