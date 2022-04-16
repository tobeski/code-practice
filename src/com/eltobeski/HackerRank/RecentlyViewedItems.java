package com.eltobeski.HackerRank;

import java.util.*;

public class RecentlyViewedItems {

    public static void main(String[] args) {
        List<String> data = List.of("Echo Show 8", "Kindle Oasis", "Fire TV Stick", "Echo Show 8");
        List<String> data2 = List.of("Smartphone", "Television", "Smartphone", "Television");
        List<String> data3 = List.of("Book1", "Book2", "Book3", "Book1","Book3");
        var result = recentItems(data3);

        System.out.println(result);
    }

    public static List<String> recentItems(List<String> logs) {
        Set<String> data = new LinkedHashSet<>();

        for (String log : logs) {
            if (data.contains(log)) {
                data.remove(log);
            }

            data.add(log);
        }

        List<String> answer = new ArrayList<>(data);

         Collections.reverse(answer);
         return answer;
    }
}
