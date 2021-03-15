package com.eltobeski.FireCode;

public class SumOfElementsInBinaryTree {

    public int sum(TreeNode root) {
        if(root==null)
            return 0;

        return root.data + sum(root.left)+sum(root.right);


    }

    /* Iterative

    if(root==null)
        return 0;

    int sum = 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    TreeNode temp;

    while(!q.isEmpty())
    {
        temp = q.poll();
        sum+=temp.data;

        if(temp.left!=null)
            q.add(temp.left);

        if(temp.right!=null)
            q.add(temp.right);
    }

    return sum;

    */

}
