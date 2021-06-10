package com.eltobeski.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board[i]))
                return false;
            if (!isValidColumn(board, i))
                return false;
        }
        return isValidBox(board);

    }

    private static boolean isValidRow(char[] row) {
        Set<Character> boxCharacters = new HashSet<>();
        for (Character character : row
        ) {
            if (Character.isDigit(character))
                if (boxCharacters.contains(character)) {
                    return false;
                }
            boxCharacters.add(character);
        }
        return true;
    }

    private static boolean isValidColumn(char[][] board, int j) {
        Set<Character> boxCharacters = new HashSet<>();
        for (int i = 0; i < 9; i++
        ) {
            if (Character.isDigit(board[i][j]))
                if (boxCharacters.contains(board[i][j])) {
                    return false;
                }
            boxCharacters.add(board[i][j]);
        }
        return true;
    }

    private static boolean isValidBox(char[][] board) {
        if (!isValidBox(board, 0, 0))
            return false;
        if (!isValidBox(board, 0, 3))
            return false;
        if (!isValidBox(board, 0, 6))
            return false;
        if (!isValidBox(board, 3, 0))
            return false;
        if (!isValidBox(board, 3, 3))
            return false;
        if (!isValidBox(board, 3, 6))
            return false;
        if (!isValidBox(board, 6, 0))
            return false;
        if (!isValidBox(board, 6, 3))
            return false;
        if (!isValidBox(board, 6, 6))
            return false;

        return true;
    }

    private static boolean isValidBox(char[][] board, int m, int n) {
        Set<Character> boxCharacters = new HashSet<>();
        for (int i = m; i < m + 3; i++) {
            for (int j = n; j < n + 3; j++) {
                Character character = board[i][j];
                if (Character.isDigit(character))
                    if (boxCharacters.contains(character)) {
                        return false;
                    }
                boxCharacters.add(character);

            }

        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }
}
