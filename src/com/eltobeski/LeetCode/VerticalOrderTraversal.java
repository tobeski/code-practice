package com.eltobeski.LeetCode;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class VerticalOrderTraversal {
    List<Position> positions;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        positions = new ArrayList<>();
        depthFirstSearch(root,0,0);

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<Integer>());

        int first = positions.get(0).x;

        for(Position pos   :  positions){
            if(pos.x != first){
                answer.add(new ArrayList<>());
            }
            else{
                answer.get(answer.size()-1).add(pos.value);
            }
            first = pos.x;
        }
        return answer;
    }

    public void depthFirstSearch(TreeNode root, int x, int y){
        if(root!= null){
            positions.add(new Position(root.data,x,y));
            depthFirstSearch(root.left,x-1,y-1);
            depthFirstSearch(root.right,x+1,y-1);
        }
    }

    class Position {
        int value;
        int x;
        int y;

        public  Position(int value,int x,int y){
            this.value = value;
            this.x = x;
            this.y = y;
        }


    }
}
