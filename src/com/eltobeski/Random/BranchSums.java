package com.eltobeski.Random;

import com.eltobeski.FireCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.eltobeski.FireCode.BinaryTreeSerialization.restoreTree;

public class BranchSums {
    static List<Integer> sums = new ArrayList<>();
    private static List<Integer> sumOfAllBranches(TreeNode treeNode){

        sumOfAllBrancesHelper(treeNode,0);
        return sums;
    }

    private static void sumOfAllBrancesHelper(TreeNode root,int sum){


        if(root!=null) {
           sum += root.data;
           if(root.left==null&&root.right==null){
               sums.add(sum);
               return;
           }
            sumOfAllBrancesHelper(root.left,sum);
            sumOfAllBrancesHelper(root.right,sum);
        }
    }

    public static void main(String[] args) {
//        TreeNode head = restoreTree("1,2,3,4,5,6,7,8,9,10,*");
        TreeNode head = restoreTree("1,2,3,4,5");

        System.out.println(sumOfAllBranches(head));

    }
}
