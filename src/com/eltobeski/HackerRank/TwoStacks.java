package com.eltobeski.HackerRank;

import java.io.*;
import java.math.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TwoStacks {

    /*
     * Complete the twoStacks function below.
     */
    static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */
        int [] max = new int[]{0};
        return helper(x,a,b,0,0,0);
    }

    static int helper(int x,int[] a, int [] b ,int i,int j, int count){
        int sum = i+j;
        if(i >= a.length){
            sum = sum-1;
            return sum;}
        if(j >= b.length){
            sum = sum-1;

        return sum;}
        if(count > x &&( i >= a.length || j >=b.length) )return sum;
        if(count > x  )return sum;

        return Math.max(helper(x,a,b,i+1,j,count+a[i]),helper(x,a,b,i,j+1,count+b[j]));
    }

    private static final  Path path = Paths.get("/Users/aoluwatobi/Documents/CodePractice/src/Testfile.txt");

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/aoluwatobi/Documents/CodePractice/src/Testfile.txt"));
          Scanner scanner = new Scanner(path);

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            System.out.println(String.valueOf(result));
        }

//        bufferedWriter.close();
    }
}
