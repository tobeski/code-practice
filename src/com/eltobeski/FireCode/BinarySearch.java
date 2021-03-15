package com.eltobeski.FireCode;

public class BinarySearch {
    public static Boolean binarySearch(int[] arr, int n) {
        int lowerEnd = 0;
        int upperEnd = arr.length - 1;
        int middle = 0;

        while (lowerEnd <= upperEnd) {
            middle = (lowerEnd + upperEnd) / 2;

            if (arr[middle] == n) {
                return true;
            }

            if (arr[middle] < n) {
                lowerEnd = middle + 1;
            } else {
                upperEnd = middle - 1;
            }
        }

        return false;
    }



    public static void main(String[] args) {
        // write your code here
        int [] arrayOfNumbers = {100};
        int n = 100;
//        System.out.println(binarySearch(arrayOfNumbers,n));
String st = "FileName.csv";
        String[] fileNameArray = st.split("\\.");
        String g = fileNameArray[fileNameArray.length-1];
        g.charAt(0);
    }
    }
