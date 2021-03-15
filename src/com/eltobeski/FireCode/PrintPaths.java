package com.eltobeski.FireCode;

import java.util.ArrayList;
import java.util.Stack;

public class PrintPaths {
    public class Path {
        String str;
        Integer row;
        Integer col;
        public Path(String s, Integer r, Integer c){
            str=s;
            row=r;
            col=c;
        }
    }

    public ArrayList<String> printPathsRecursively(char[][] board){
        ArrayList<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        searchUtil(0,0,board,sb,output);
        return output;
    }


    public void searchUtil(int i,int j,char[][] board,StringBuilder sb, ArrayList<String> out){
        if(i>board.length-1||j>board[0].length-1) return;
        sb.append(board[i][j]);
        if(i==board.length-1&&j==board[0].length-1){
            out.add(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        searchUtil(i+1,j,board,sb,out);
        searchUtil(i,j+1,board,sb,out);
        sb.deleteCharAt(sb.length()-1);


    }

    public ArrayList<String> printPaths(char[][] board){
        ArrayList<String> lst = new ArrayList<>();
        if(board==null) return lst;
        Integer nrow = board.length-1;
        if(nrow==-1) return lst;
        Integer ncol = board[0].length-1;
        if(ncol==-1) return lst;
        Stack<Path> stk = new Stack<>();
        stk.add(new Path(Character.toString(board[0][0]),0,0));

        while(!stk.isEmpty()){
            Path p = stk.pop();
            if(p.row.equals(nrow) && p.col.equals(ncol)){
                lst.add(p.str);
            }
            if(p.row<nrow){
                stk.add(new Path(p.str+(board[p.row+1][p.col]), p.row+1, p.col));
            }
            if(p.col<ncol){
                stk.add(new Path(p.str+(board[p.row][p.col+1]), p.row, p.col+1));
            }

        }
        return lst;
    }
}
