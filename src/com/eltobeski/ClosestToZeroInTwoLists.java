package com.eltobeski;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class ClosestToZeroInTwoLists {

    public static void main(String[] args) {
//        Integer[] arrA = new Integer[]{-1,5,10,5,28,3};
//        Integer[] arrB = new Integer[]{26,134,5,15,17};
        int[] arrayOne = new int[]{10, 0, 20, 25, 2000};
        int[] arrayTwo = new int[]{1005, 1006, 1014, 1032, 1031};
        System.out.println(Arrays.toString(smallestDifference(arrayOne,arrayTwo)));
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        List<Integer> list1 = Arrays.stream(arrayOne).boxed().collect(toList());
        List<Integer> list2 = Arrays.stream(arrayTwo).boxed().collect(toList());

        Set<Integer> setOne = new TreeSet<>(list1);
        Set<Integer> setTwo = new TreeSet<>(list2);
        Map<String, Object> db = new HashMap<>();
        db.put("smallest", Integer.MAX_VALUE);
        db.put("data", new int[2]);
        Integer prev = null;
        for (Integer first : setOne) {
            if (setTwo.contains(first)) {
                return new int[]{first, first};
            }
        }
        for (Integer first : setOne) {
            int i = 0;

            for (Integer second : setTwo) {

                if (i == 0 && first < second) {

                    int currentDiff = Math.abs(first - second);

                    if (Integer.parseInt(db.get("smallest").toString()) > currentDiff) {
                        db.put("smallest", currentDiff);
                        db.put("data", new int[]{first, second});
                    }

                    break;
                }
                if (i != 0 && first < second) {
                    int currentDiff = Math.abs(first - second);
                    int prevDiff = Math.abs(first - prev);
                    if (currentDiff < prevDiff) {

                        if (Integer.parseInt(db.get("smallest").toString()) > currentDiff) {
                            db.put("smallest", currentDiff);
                            db.put("data", new int[]{first, second});
                            break;

                        }
                    } else {

                            if (Integer.parseInt(db.get("smallest").toString()) > prevDiff) {
                                db.put("smallest", prevDiff);
                                db.put("data", new int[]{first, prev});
                                break;
                            }
                    }
                    continue;

                }
                if(i==setTwo.size()-1&&first>second){
                    if (Integer.parseInt(db.get("smallest").toString()) > (first-second)) {
                        db.put("smallest",  Math.abs(first - second));
                        db.put("data", new int[]{first, second});
                        break;
                    }
                }

                i++;
                prev = second;
            }
            }
        // Write your code here.
        return (int[]) db.get("data");
    }
}
