package com.eltobeski.FireCode;

import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CombineParanthesis {
    public static ArrayList<String> combParenthesis(int pairs) {
        Queue<OpenPara> queue = new LinkedList<>();
        ArrayList<String> answer = new ArrayList<>();
        if (pairs == 0) return answer;
        queue.offer(new OpenPara("(", pairs - 1, pairs));
        while (!queue.isEmpty()) {
            OpenPara pa = queue.poll();
            if (pa.left > 0) {
                queue.offer(new OpenPara(pa.sb + "(", pa.left - 1, pa.right));
            }
            if (pa.right > 0 && pa.left < pa.right) {
                queue.offer(new OpenPara(pa.sb + ")", pa.left, pa.right - 1));
            }
            if (pa.right == 0 && pa.left == 0) {
                answer.add(pa.sb);
            }
        }


        return answer;


    }

    public static ArrayList<String> combParenthesis2(int pairs) {
        ArrayList<String> result = new ArrayList<>();
        helper("", pairs, pairs, result);
        return result;
    }

    private static void helper(String s, int left, int right, ArrayList<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
        }

        if (left > 0) {
            helper(s + "(", left - 1, right, result);
        }

        if (right > left) {
            helper(s + ")", left, right - 1, result);
        }
    }


    public static class OpenPara {
        public String sb;
        public int left;
        public int right;


        public OpenPara(String sb, int left, int right) {
            this.sb = sb;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        System.out.println(combParenthesis(3));
        System.out.println(combParenthesis2(3));
    }
}
