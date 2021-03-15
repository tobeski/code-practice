package com.eltobeski.FireCode.MergeIntervals;

import com.eltobeski.FireCode.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervalsList) {
        ArrayList<Interval> finalList = new ArrayList<>();
        if(intervalsList==null || intervalsList.isEmpty())
            return finalList;
        Collections.sort(intervalsList, (entry1, entry2) -> {
            if(entry1.start == entry2.start){
                return entry1.end - entry2.end;
            }
            return entry1.start - entry2.start;
        });
        Interval current = intervalsList.get(0);
        Interval nextInterval;
        for  (int i = 1; i < intervalsList.size(); i++) {
            nextInterval = intervalsList.get(i);
            if(nextInterval.start<=current.end){
                  current= new Interval(current.start, Math.max(current.end, nextInterval.end));

            }
            else {
                finalList.add(current);
                current = new Interval(nextInterval.start, nextInterval.end);
            }

        }
        finalList.add(current);
        return finalList;
    }

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(3,5));
        list.add(new Interval(1,4));
        ArrayList<Interval> finalList = mergeIntervals(list);
        System.out.println(finalList);
    }
    }