package DSAAdvanced.ProblemOnTrees2;

import DSAAdvanced.TreeNode;

public class maximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode A) {
        //now if A is null then we return 0
        if(A==null)
            return 0;
        //to find maximum depth of binary tree we have to sum all nodes till leaf node
        //we will see what is depth in left side
        int l=maxDepth(A.left);
        //we will see what is depth in right side
        int r=maxDepth(A.right);
        //now we will take maximum of two and add 1+Max(l,r)
        return 1+Math.max(l,r);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        TreeNode B1= new TreeNode(2);
        TreeNode B2= new TreeNode(3);
        A.left=B1;
        A.right=B2;
        TreeNode C1= new TreeNode(4);
        TreeNode C2= new TreeNode(5);
        B1.left=C1;
        B1.right=C2;
        System.out.println(maxDepth(A));
    }
}
