package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
    public static List<String> exist(char[][] board, String[] words) {
        boolean[][] discovered = new boolean[board.length][board[0].length];
        HashSet<String> ans = new HashSet<>();
        for (int row = 0; row < board.length; ++row)
            for (int col = 0; col < board[0].length; ++col) {
                for (String word : words)
                    if (board[row][col] == word.charAt(0))
                        if (helper(board, word, row, col, word.length(), discovered))
                            ans.add(word);
            }
        return  new ArrayList<>(ans);
    }

    private static boolean helper(char[][] board, String word, int i, int j, int length, boolean[][] discovered) {
        if (length == 0) return true;

        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) return false;
        boolean found = false;
        if (board[i][j] == word.charAt(0)) found = true;
        boolean ans;
        if (found && !discovered[i][j]) {
            length = length - 1;
            discovered[i][j] = true;
            ans = length == 0 || helper(board, word.substring(1), i + 1, j, length, discovered) ||
                    helper(board, word.substring(1), i, j + 1, length, discovered) ||
                    helper(board, word.substring(1), i, j - 1, length, discovered) ||
                    helper(board, word.substring(1), i - 1, j, length, discovered);


        } else {
            return false;
        }
        discovered[i][j] = false;

        return ans;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] word = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(exist(board, word));

    }
}
