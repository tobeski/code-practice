package com.eltobeski.FireCode.GetStringFromNums;

import java.util.*;

public class GetStringFromNums {
    public static ArrayList<String> getStringsFromNums(String digits) {
        if (digits == null)
            return new ArrayList<>();
        Map<Integer, char[]> numberMap = new HashMap<>();
        numberMap.put(2, new char[]{'a', 'b', 'c'});
        numberMap.put(3, new char[]{'d', 'e', 'f'});
        numberMap.put(4, new char[]{'g', 'h', 'i'});
        numberMap.put(5, new char[]{'j', 'k', 'l'});
        numberMap.put(6, new char[]{'m', 'n', 'o'});
        numberMap.put(7, new char[]{'p', 'q', 'r', 's'});
        numberMap.put(8, new char[]{'t', 'u', 'v'});
        numberMap.put(9, new char[]{'w', 'x', 'y', 'z'});
        ArrayList<String> answer = new ArrayList<>();

        Deque<String> permutations = new ArrayDeque<>();
        for (char c : numberMap.get(Integer.parseInt(digits.charAt(0) + ""))
        ) {
            permutations.offer(c + "");
        }
        int d = 1;
        if (digits.length() < 2)
            return getStringsFromQueue(permutations, answer);
        while (!permutations.isEmpty() ) {
            String s = permutations.poll();
            if (s.length() == digits.length()) {
                answer.add(s);
                continue;
            }
            for (char c : numberMap.get(Integer.parseInt(digits.charAt(d) + ""))
            ) {
                permutations.offer(s + c);
            }
            if (permutations.getFirst().length() == permutations.getLast().length())
                d++;
        }
        return answer;
    }

    private static ArrayList<String> getStringsFromQueue(Deque<String> permutations, ArrayList<String> answer) {
        while (!permutations.isEmpty()) {
            answer.add(permutations.poll());
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(getStringsFromNums("2"));
    }
}
