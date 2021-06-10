package com.eltobeski.FireCode;

import java.util.*;

public class BoggleSearchWithDictionary {

    public static ArrayList<String> boggleSearchWithDict(char[][] board, ImplementingATrie.Trie dictionary) {
        if (board == null)
            return new ArrayList<>();
        Deque<LetterLocation> viablePrefixes = new ArrayDeque<>();
        Set<String> answerSet = new TreeSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                String s = board[i][j] + "";
                boolean[][] used = new boolean[board.length][board[0].length];
                used[i][j] = true;
                viablePrefixes.offer(new LetterLocation(s, i, j, used));

                while (!viablePrefixes.isEmpty()) {

                    LetterLocation word = viablePrefixes.poll();
                    used = word.used;
                    if (word.x - 1 >= 0 && !used[word.x - 1][word.y]) {

                        String newWord = word.word + board[word.x - 1][word.y];
                        if (dictionary.searchWord(newWord)) {
                            answerSet.add(newWord);
                        }
                        if (dictionary.searchPrefix(newWord)) {
                            LetterLocation letterLocation = new LetterLocation(newWord, word.x - 1, word.y, used);
                            letterLocation.used[word.x - 1][word.y] = true;
                            viablePrefixes.offer(letterLocation);

                        }
                    }
                    if (word.x + 1 < board.length && !used[word.x + 1][word.y]) {
                        String newWord = word.word + board[word.x + 1][word.y];
                        if (dictionary.searchWord(newWord)) {
                            answerSet.add(newWord);
                        }
                        if (dictionary.searchPrefix(newWord)) {
                            LetterLocation letterLocation = new LetterLocation(newWord, word.x +1, word.y, used);
                            letterLocation.used[word.x + 1][word.y] = true;
                            viablePrefixes.offer(new LetterLocation(newWord, word.x + 1, word.y, used));
                        }

                    }
                    if (word.y - 1 >= 0 && !used[word.x][word.y - 1]) {
                        String newWord = word.word + board[word.x][word.y - 1];

                        if (dictionary.searchWord(newWord)) {
                            answerSet.add(newWord);
                        }
                        if (dictionary.searchPrefix(newWord)) {
                            LetterLocation letterLocation = new LetterLocation(newWord, word.x , word.y-1, used);
                            letterLocation.used[word.x][word.y - 1] = true;
                            viablePrefixes.offer(new LetterLocation(newWord, word.x, word.y - 1, used));
                        }

                    }
                    if (word.y + 1 < board[0].length && !used[word.x][word.y + 1]) {
                        String newWord = word.word + board[word.x][word.y + 1];
                        if (dictionary.searchWord(newWord)) {
                            answerSet.add(newWord);
                        }
                        if (dictionary.searchPrefix(newWord)) {
                            LetterLocation letterLocation = new LetterLocation(newWord, word.x , word.y+1, used);
                            letterLocation.used[word.x][word.y + 1] = true;
                            viablePrefixes.offer(new LetterLocation(newWord, word.x, word.y + 1, used));
                        }

                    }

                }
            }
        }
        return new ArrayList<>(answerSet);


    }

    static class LetterLocation {
        String word;
        boolean[][] used;
        int x;
        int y;

        LetterLocation(String word, int x, int y, boolean[][] used) {
            this.word = word;
            this.x = x;
            this.y = y;
            this.used = Arrays.stream(used).map(boolean[]::clone).toArray(boolean[][]::new);

        }

    }

    public static void main(String[] args) {
        ImplementingATrie.Trie dictionary = new ImplementingATrie.Trie();
        dictionary.insertWord("CODING");
        dictionary.insertWord("INTERVIEW");
        char[][] board = new char[][]{
                {'A', 'F', 'G', 'N'},
                {'N', 'I', 'D', 'I'},
                {'T', 'E', 'R', 'V'},
                {'C', 'G', 'E', 'I'},
                {'O', 'N', 'F', 'E'},
                {'D', 'I', 'E', 'W'}
        };
        System.out.println(BoggleSearchWithDictionary.boggleSearchWithDict(board, dictionary));
    }
}
