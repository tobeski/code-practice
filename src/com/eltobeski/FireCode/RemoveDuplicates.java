package com.eltobeski.FireCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class RemoveDuplicates {
    public static ArrayList<String> removeDuplicates(List<String> input) {
        ArrayList<String> list = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>(input);


        for (String element : set) {
            list.add(element);
        }
        return list;
    }
}
