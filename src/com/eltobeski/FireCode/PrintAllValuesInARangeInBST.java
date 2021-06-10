package com.eltobeski.FireCode;

import java.util.ArrayList;
import java.util.List;

public class PrintAllValuesInARangeInBST {
    public List<Integer> rangeList = new ArrayList<>();
    public void printRange(TreeNode root, int a, int b) {
        if(root == null)
            return;

        printRange(root.left,a,b);

        if(root.data>=a&&root.data<=b)
            rangeList.add(root.data);

        printRange(root.right,a,b);




    }
}
