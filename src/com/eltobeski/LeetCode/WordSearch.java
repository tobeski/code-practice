package com.eltobeski.LeetCode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        boolean[][] discovered = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; ++row)
            for (int col = 0; col < board[0].length; ++col) {
                if(board[row][col]==word.charAt(0))
                    if (helper(board, word, row, col, word.length(), discovered))
                        return true;
            }
        return false;
    }

    private static boolean helper(char[][] board, String word,int i,int j, int length,boolean[][] discovered) {
        if(length==0) return true;

        if(i>= board.length || j>= board[0].length||i<0||j<0) return false;
        boolean found = false;
        if(board[i][j] == word.charAt(0)) found=true;
        boolean ans ;
        if(found && !discovered[i][j]) {
            discovered[i][j] = true;
            length = length - 1;
            ans = length == 0 || helper(board, word.substring(1), i + 1, j, length,discovered) ||
                    helper(board, word.substring(1), i, j + 1, length,discovered)||
                    helper(board, word.substring(1), i, j-1, length,discovered)||
                    helper(board, word.substring(1), i-1, j, length,discovered);


        }
        else {
            return false;
        }
        discovered[i][j] = false;

        return ans;
    }

    public static void main(String[] args){
        char[][] board = new char[][]{{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
        String word = "aaaaaaaaaaaaa";
        System.out.println(exist(board,word));

    }
}
