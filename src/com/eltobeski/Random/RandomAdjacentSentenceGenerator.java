package com.eltobeski.Random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RandomAdjacentSentenceGenerator {
    //Hello Baby Your Baby Says Hello

    //The cat and the mouse
    //Sample Answer
    //The cat and the cat

    //Sample Answer
    //Baby Your Baby Your Baby Says
    Set<String> answers;

    public static void main(String[] args) {
        RandomAdjacentSentenceGenerator randomAdjacentSentenceGenerator = new RandomAdjacentSentenceGenerator();
        randomAdjacentSentenceGenerator.randomWordGenerator("The cat and the mouse");
//        randomAdjacentSentenceGenerator.randomWordGenerator("Hello Baby Your Baby Says Hello");
        Map<String,Set<String>> asas = randomAdjacentSentenceGenerator.wordMapAdjecencySerializer("The cat and the mouse");
        for (String s : asas.keySet()) {
            System.out.println(s+": "+asas.get(s));

        }
    }

    private void randomWordGenerator(String sentence) {
        answers = new HashSet<>();
        Map<String, Set<String>> wordDistribution = wordMapAdjecencySerializer(sentence);
        sentence = sentence.toLowerCase();
        String[] wordArray = sentence.split(" ");
        for (String s : wordDistribution.keySet()) {
            randomWordGeneratorHelper(wordDistribution, s, "", 0, wordArray.length);
        }
        for (String word:answers
             ) {
            System.out.println(word);
        }

    }

    //1st iteration noOfWords=0 newSentence = "" key=baby
    //2nd Iteration noOfWords=1 newSentence = "baby" key=your
    //3rd Iteration noOfWords=2 newSentence = "baby your" key=baby
    //4rd Iteration noOfWords=3 newSentence = "baby your baby" key=your
    //.
    //.
    //.
    //7th Iteration noOfWords=6 newSentence = "baby your baby your baby your" key=baby

    private void randomWordGeneratorHelper(Map<String, Set<String>> wordDistribution, String key,
                                           String newSentence, int noOfWords, int total) {
        if (noOfWords == total) {
//            System.out.println(newSentence);
            answers.add(newSentence);
        }
        else {
            if (newSentence.isEmpty())
                newSentence = key;
            else
                newSentence += " " + key;

            if (wordDistribution.containsKey(key)) {
                for (String s : wordDistribution.get(key)
                ) {
                    randomWordGeneratorHelper(wordDistribution, s, newSentence, noOfWords + 1, total);
                }
            }
            else if(noOfWords+1==total)
                answers.add(newSentence);
        }
    }

    private Map<String, Set<String>> wordMapAdjecencySerializer(String sentence) {
        sentence = sentence.toLowerCase();
        String[] wordArray = sentence.split(" ");
        Map<String, Set<String>> wordDistribution = new HashMap<>();
        for (int i = 0; i < wordArray.length - 1; i++
        ) {
            String currentWord = wordArray[i];
            Set<String> words;
            if (wordDistribution.containsKey(currentWord)) {
                words = wordDistribution.get(currentWord);
            } else {
                words = new HashSet<>();
            }
            words.add(wordArray[i + 1]);
            wordDistribution.put(currentWord, words);
        }
        return wordDistribution;
    }

}
