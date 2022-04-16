package com.eltobeski.LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        List<Integer> v1Array = Arrays.stream(version1.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> v2Array = Arrays.stream(version2.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());


        while (v1Array.size() < v2Array.size()) {
            v1Array.add(0);
        }
        while (v2Array.size() < v1Array.size()) {
            v2Array.add(0);
        }
        for (int i = 0; i <v1Array.size() ; i++) {
            if(v1Array.get(i)< v2Array.get(i)){
                return -1;
            }
            if(v2Array.get(i)< v1Array.get(i)){
                return 1;
            }
        }


        return 0;
    }

    public int compareVersionAlternate(String version1, String version2) {
        while(version1.length() > 0 || version2.length() > 0){
            int i1 = version1.indexOf("."), i2 = version2.indexOf(".");
            int v1 = i1 < 0 ? version1.length() == 0 ? 0 : Integer.parseInt(version1) : Integer.parseInt(version1.substring(0,i1));
            int v2 = i2 < 0 ? version2.length() == 0 ? 0 : Integer.parseInt(version2) : Integer.parseInt(version2.substring(0,i2));
            if(i1 == -1) version1 = "";
            if(i2 == -1) version2 = "";
            version1 = version1.substring(i1+1);
            version2 = version2.substring(i2+1);
            if(v1 < v2) return -1;
            if(v1 > v2) return 1;
            if(i1 == -1 && i2 == -1) break;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.1","1"));
    }
}
