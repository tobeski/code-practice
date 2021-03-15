package com.eltobeski.LeetCode;

import java.util.*;

public  class KClosestPointToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
    if(K == points.length) return points;
    TreeMap<Integer,List<Point>> treeMap = new TreeMap<>();
    int[][] ans = new int [K][2];
    for(int[] point : points){
        int eucle = eucledian(point);
        treeMap.putIfAbsent(eucle,new ArrayList<>());
        treeMap.get(eucle).add(new Point(point[0],point[1]));
    }
    int counter = 0;

    for(Map.Entry<Integer,List<Point>> entry : treeMap.entrySet()){
        for(Point pointss : entry.getValue()){
            ans[counter][0] = pointss.x;
            ans[counter][1] = pointss.y;
            counter++;
            if(counter==K) return ans;
        }

    }
    return ans;

}

    public static int[][] kClosestAlt(int[][] points, int K) {
        if(K == points.length) return points;
        int[][] ans = new int [K][2];
        PriorityQueue<int[]> sortedAnswer = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int[] point : points){
            int eucle = eucledian(point);
            sortedAnswer.add(new int[]{eucle,point[0],point[1]});
        }
        for(int i = 0; i<K;i++){
            int[] point = sortedAnswer.poll();
            ans[i][0] = point[1];
            ans[i][1] = point[2];
        }
        return  ans;

    }

public static void main(String[] args){
  int [][] ans =   kClosest(new int[][]{{-5,4},{-6,-5},{4,6}},  2);
  int [][] ans2 =   kClosestAlt(new int[][]{{-5,4},{-6,-5},{4,6}},  2);
  ans = ans2;
  TreeMap<Integer,Integer> tm = new TreeMap<>();
  tm.put(1,2);
  tm.put(2,3);

  tm.floorKey(2);
}

    public static int eucledian(int[] point){
        int sum = (int)(Math.pow(point[0],2) + Math.pow(point[1],2));
        return sum;
    }

    public static class Point{
        public  int x;
        public  int y;

        public Point(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
}
