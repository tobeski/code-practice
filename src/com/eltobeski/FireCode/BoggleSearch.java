package com.eltobeski.FireCode;

public class BoggleSearch {
    public static boolean boggleSearch(char[][] board, String word){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(boggleSearchHelper(board, i, j, word))
                    return true;
            }
        }
        return false;
    }

    private static boolean boggleSearchHelper(char[][] board,int i,int j,String word){
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='@')
            return false;

        if(board[i][j]==word.charAt(0)&&word.length()==1)
            return true;
        if(board[i][j]!=word.charAt(0))
            return false;

        board[i][j] = '@';
        return boggleSearchHelper(board,i+1,j,word.substring(1))||boggleSearchHelper(board,i-1,j,word.substring(1))||
                boggleSearchHelper(board,i,j+1,word.substring(1))||boggleSearchHelper(board,i,j-1,word.substring(1));
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'A','O','L'},
//                {'D','A','L'},
//                {'G','H','I'}
//        };
        char[][] board = new char[][]{
                {'A', 'F', 'G', 'N'},
                {'N', 'I', 'D', 'I'},
                {'T', 'E', 'R', 'V'},
                {'C', 'G', 'E', 'I'},
                {'O', 'N', 'F', 'E'},
                {'D', 'I', 'E', 'W'}
        };
        System.out.println(boggleSearch(board,"INTERVIEW"));
    }
}
