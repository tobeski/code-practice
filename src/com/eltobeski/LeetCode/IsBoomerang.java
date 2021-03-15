package com.eltobeski.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class IsBoomerang {
    public static boolean isBoomerang(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] entry1, int[] entry2) {
                if(entry1[0] == entry2[0]){
                    return entry2[1] - entry1[1];
                }
                return entry2[0] - entry1[0];
            }
        });
        double[] gradients = new double[points.length-1];
        for(int i =0;i<points.length-1;i++){
            if(points[i][0]==points[i+1][0]&&points[i][1]==points[i+1][1]) return false;
            gradients[i] = gradientOfTwoPoints(points[i][0],points[i+1][0],points[i][1],points[i+1][1]);
        }
        for (int i=0;i<gradients.length-1;i++){
            if(gradients[i]==gradients[i+1])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[][] hello = new int[][]{{0,0},{0,2},{2,1}};
        System.out.println(isBoomerang(hello));
    }

    private static double gradientOfTwoPoints(int x1,int x2, int y1, int y2){
        if(x2-x1==0) return (y2-y1)/(Integer.MAX_VALUE*1.0) ;
        return (y2-y1)/((x2-x1) *1.0);
    }

    public boolean isBoomerang2(int[][] points) {

        //Three points are colliner if the area of the triangle formed by them is zero.
        //Formula = (x1*(y2-y3))+(x2*(y3-y1))+ (x3*(y1-y2)
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        return (((x1*(y2-y3))+(x2*(y3-y1))+ (x3*(y1-y2)))!=0);
    }
}
