package com.eltobeski;


import java.util.*;

public class GroupResults {
//    @Test
    void name() {
        String[] T = new String[]{"codility1", "codility3", "codility2", "codility4b", "codility4a"};
        String[] R = new String[]{"Wrong Answer", "OK", "OK", "Runtime error", "OK"};

        int result = solution(T, R);
        System.out.println(result);
    }

    public int solution(String[] T, String[] R) {
        //seperate the grouped and ungrouped

        Set<String> ungrouped = new HashSet<>();
        int unGroupCount = 0;
        Set<String> grouped = new HashSet<>();

        Map<String, Set<String>> groupedResult = new HashMap<>();
        for (String s : T) {
            if (Character.isLetter(s.charAt(s.length() - 1))) {
                grouped.add(s);
            } else {
                ungrouped.add(s);
            }
        }

        for (int i = 0; i < T.length; i++) {
            if (ungrouped.contains(T[i]) && "OK".equals(R[i])) {
                unGroupCount++;
            }

            if (grouped.contains(T[i])) {
                String group = getGroup(T[i]);
                Set<String> answers = groupedResult.getOrDefault(group, new HashSet<>());
                answers.add(R[i]);

                groupedResult.put(group, answers);
            }
        }

        int totalSuccessFulGroup = Math.toIntExact(groupedResult.entrySet()
                .stream()
                .filter(i -> i.getValue().size() == 1 && i.getValue().contains("OK"))
                .count());

        int totalGroups = ungrouped.size() + groupedResult.size();
        int totalSuccessful = totalSuccessFulGroup + unGroupCount;

        int numerator = 100 * totalSuccessful;

        return Math.floorDiv(numerator, totalGroups);
    }


    private static String getGroup(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                return s.substring(0, i + 1);
            }
        }

        return s;
    }
}
