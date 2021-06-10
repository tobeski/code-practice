package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    List<List<Integer>> answers;

    public List<List<Integer>> subsets(int[] nums) {
        answers = new ArrayList<>();
        if (nums == null)
            return new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length; i++) {
            subsetHelper(nums, new ArrayList<>(), 0, i);
        }
        return answers;
    }

    private void subsetHelper(int[] nums, List<Integer> ints, int i, int size) {
        if (ints.size() == size) {
            answers.add(new ArrayList<>(ints));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            ints.add(nums[j]);
            subsetHelper(nums, ints, j + 1, size);
            ints.remove(ints.size()-1);
        }

    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
        System.out.println(subsets.subsets(new int[]{0}));
    }
}
