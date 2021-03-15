package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmallestNumbersThanCurrent {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int position = 0;
        int[] ans = new int[nums.length];
        int numberOfPrevious = 0;
        List<Point> points = new ArrayList<>();
        for(int x : nums){

            Point point = new Point(position,x);
            position++;
            points.add(point);
        }
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.data-o2.data;
            }
        });
        ans[points.get(0).x] = 0;
        for (int i = 1; i < nums.length; i++) {
            Point point = points.get(i);
            Point prevPoint = points.get(i-1);
            int biggerPoints =0;
            if(point.data>prevPoint.data){
                biggerPoints = i;
                ans[point.x] =biggerPoints ;
            }
            else {
                biggerPoints = numberOfPrevious;
                ans[point.x] = numberOfPrevious;
            }
            numberOfPrevious = biggerPoints;
        }
        return ans;
    }

    public static void main (String[] args){
        smallerNumbersThanCurrent(new int[]{1,2,8,6,100,2});
    }

    public static class Point{
        public  int x;
        public  int data;

        public Point(int x , int data){
            this.x = x;
            this.data = data;
        }
    }
}
