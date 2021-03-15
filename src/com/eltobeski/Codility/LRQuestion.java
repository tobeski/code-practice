package com.eltobeski.Codility;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRQuestion {
    public int solution(int N) {
        // write your code in Java SE 8

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int l = current[0];
            int r = current[1];
            int level = current[2];
            if (l == N || r == N) return level;
            if (r != Integer.MIN_VALUE && r != Integer.MAX_VALUE) {
                queue.offer(new int[]{l, 2 * r - l, ++level});
            }

            if (l != Integer.MIN_VALUE && l != Integer.MAX_VALUE) {
                queue.offer(new int[]{2 * l - r, r, ++level});
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 2;
        int max = 2;
        System.out.println(altSolution(N, max));
        System.out.println(altSolutionRecursion(N, max, 0));
    }

    static HashMap<String, Integer> map = new HashMap<>();

    public static int solution(int target, int maxAllIns) {
        return findMinTimeUtil(1, target, maxAllIns, map);
    }

    private static int findMinTimeUtil(int curr, int target, int maxAllIns, HashMap<String, Integer> map) {
        if (curr > target) {
            return Integer.MAX_VALUE;
        }
        if (curr == target) {
            return 0;
        }
        if (maxAllIns == 0) {
            return target - curr;
        }
        String key = curr +
                ":" +
                maxAllIns;
        if (!map.containsKey(key)) {
            int min1 = findMinTimeUtil(curr + 1, target, maxAllIns, map);
            int min2 = findMinTimeUtil(curr * 2, target, maxAllIns - 1, map);
            map.put(key, Math.min(min1, min2));
        }
        return 1 + map.get(key);
    }

    private static int altSolution(int target, int maxAllIns) {
        int level = 0;
        if (maxAllIns == 0) {
            return target - 1;
        }
        while (target > 1) {
            if (target % 2 == 0 && maxAllIns > 0) {
                target = target / 2;
                maxAllIns--;
                level++;
            } else {
                target--;
                level++;
            }
        }
        return level;
    }

    private static int altSolutionRecursion(int target, int maxAllIns, int level) {
        if (target == 0)
            return level - 1;

        if (maxAllIns == 0) {
            return level + (target - 1);
        }

        if (target % 2 == 0 && maxAllIns > 0) {
            return altSolutionRecursion(target / 2, maxAllIns - 1, level + 1);
        } else {
            return altSolutionRecursion(target - 1, maxAllIns, level + 1);
        }
    }
}
