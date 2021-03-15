package com.eltobeski.HackerRank;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {
    static Map<Integer, Integer> numFreqs = new HashMap<>();
    static Map<Integer, Integer> freqOccurs = new HashMap<>();

    private static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> answer = new ArrayList<>();
        for (List<Integer> query : queries) {

            Integer type = query.get(0);
            Integer number = query.get(1);
            if (type == 1) {
                insertNumber(number, numFreqs);
            } else if (type == 2) {
                removeOne(number, numFreqs);
            } else if (type == 3) {
                answer.add(checkIfFrequencyPresent(number));
            }
        }
        return answer;
    }

    static Map<Integer, Integer> insertNumber(Integer x, Map<Integer, Integer> frequencyMap) {
        Integer frequency = frequencyMap.getOrDefault(x, 0);
        freqOccurs.put(frequency, freqOccurs.getOrDefault(frequency, 0) - 1);
        frequencyMap.put(x, frequency + 1);
        frequency = frequencyMap.get(x);
        freqOccurs.put(frequency, freqOccurs.getOrDefault(frequency, 0) + 1);

        return frequencyMap;
    }

    static Map<Integer, Integer> removeOne(Integer x, Map<Integer, Integer> frequencyMap) {
        if (frequencyMap.containsKey(x)) {
            Integer num = frequencyMap.get(x);
            if (num == 0) return frequencyMap;
            freqOccurs.put(num, freqOccurs.getOrDefault(num, 0) - 1);
            frequencyMap.put(x, frequencyMap.get(x) - 1);
            num = frequencyMap.get(x);
            freqOccurs.put(num, freqOccurs.get(num) + 1);
        }

        return frequencyMap;
    }

    static Integer checkIfFrequencyPresent(Integer x) {
        if (freqOccurs.getOrDefault(x, 0) > 0) return 1;
        return 0;
    }


    private static final Path path = Paths.get("/Users/aoluwatobi/Documents/CodePractice/src/HRTest.txt");

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/aoluwatobi/Documents/CodePractice/src/Testfile.txt"));
        System.out.println(LocalTime.now());
        Scanner scanner = new Scanner(path);


        int q = Integer.parseInt(scanner.nextLine().trim());


        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println(LocalTime.now());

        List<Integer> ans = freqQuery(queries);

        for (Integer a : ans
                ) {
            System.out.println(a);
        }
        System.out.println(LocalTime.now());


    }


}

