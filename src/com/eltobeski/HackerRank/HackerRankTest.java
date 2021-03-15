package com.eltobeski.HackerRank;

import java.util.*;

public class HackerRankTest {
    public static void commonSubstring(List<String> a, List<String> b) {
        // Write your code here
        Set<Character> leftSet ;
        boolean found = false;
        int length = a.size();

        for(int i = 0; i<length;i++) {
            found= false;
            leftSet=new HashSet<>();
            for (Character c : a.get(i).toCharArray()
                    ) {
                leftSet.add(c);


            }
            for (Character c : b.get(i).toCharArray()
                    ) {
                if (leftSet.contains(c)) {
                    System.out.println("YES");
                    found = true;
                    break;
                }
            }
            if (found == false) {
                System.out.println("NO");
            }
        }

    }

    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        // Write your code here
        Collections.sort(h);
        Collections.sort(v);
        int hSize = h.size();
        int vSized = v.size();




        int largestSpaceVertival = 1;
        int currentSpaceH = 1;
        int currentSpaceV = 1;
        boolean continous = false;
        int largestSpaceHorizontal = 1;

        for (int i = 0; i < hSize-1; i++) {
                if(h.get(i+1)-h.get(i)==1){

                    currentSpaceH++;
                    if(currentSpaceH>largestSpaceHorizontal)
                        largestSpaceHorizontal = currentSpaceH;
                }
                else {
                    currentSpaceH = 1;
                }


        }
        for (int j = 0; j < vSized-1; j++) {
            if(v.get(j+1)-v.get(j)==1){
                    currentSpaceV++;
                    if(currentSpaceV>largestSpaceVertival)
                        largestSpaceVertival = currentSpaceV;
                }
                else currentSpaceV =1;
            }


largestSpaceHorizontal +=1;
        largestSpaceVertival+=1;
        return largestSpaceHorizontal*largestSpaceVertival;

    }    public static long prison2(int n, int m, List<Integer> h, List<Integer> v) {
        // Write your code here

        Set<Integer> hSet = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            hSet.add(h.get(i));
        }
        Set<Integer> vSet = new HashSet<>();
        for (int i = 0; i < v.size(); i++) {
            vSet.add(v.get(i));
        }
        List<Integer> rows = new ArrayList<>();
        rows.add(0);
        for (int i = 1; i <= n; i++) {
            if (!hSet.contains(i)) rows.add(i);
        }
        rows.add(n + 1);
        List<Integer> cols = new ArrayList<>();
        cols.add(0);
        for (int i = 1; i <= m; i++) {
            if (!vSet.contains(i)) cols.add(i);
        }
        cols.add(m + 1);
        int maxRMargin = 1;
        for (int i = 0; i < rows.size() - 1; i++) {
            int currentMargin = rows.get(i + 1) - rows.get(i);
            maxRMargin = Math.max(currentMargin, maxRMargin);
        }
        int maxCMargin = 1;
        for (int i = 0; i < cols.size() - 1; i++) {
            int currentMargin = cols.get(i + 1) - cols.get(i);
            maxCMargin = Math.max(currentMargin, maxCMargin);
        }
        return maxCMargin * maxRMargin;
    }

    public static void main(String[] args){
//        List<String> a = new ArrayList<>();
//        a.add("ab");
//        a.add("cd");
//        a.add("ef");
//        List<String> b= new ArrayList<>();
//        b.add("af");
//        b.add("ee");
//        b.add("ef");
        List<Integer> a = new ArrayList<>();
        a.add(4);
//        a.add(2);
//        a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(2);
//        b.add(2);



        System.out.println(prison(3,2,a,b));
    }
}
