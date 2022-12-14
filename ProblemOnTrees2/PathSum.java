package DSAAdvanced.ProblemOnTrees2;

import DSAAdvanced.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PathSum {
    public static int maxPathSum(TreeNode A){
        Sum(A);
        return max;
    }
    static int max=Integer.MIN_VALUE;
    public static int Sum(TreeNode A){
        if(A==null)
            return 0;
        int l=Sum(A.left);
        int r=Sum(A.right);
        int p=A.val+Math.max(l,0)+Math.max(r,0);
        max=Math.max(p,max);
        return A.val+Math.max(0,Math.max(l,r));
    }

    public static long pathSum(TreeNode A){
        if(A==null)
            return 0;
        long lstSum=pathSum(A.left);
        long rstSum=pathSum(A.right);
        long max=Math.max(lstSum,rstSum);
        return A.val+(int)Math.max(max,0);
    }


    public static void main(String[] args) {
        TreeNode A= new TreeNode(20);
        TreeNode B1= new TreeNode(-10);
        TreeNode B2= new TreeNode(20);
        TreeNode C1= new TreeNode(-10);
        TreeNode C2= new TreeNode(-50);
        A.left=B1;
        A.right=B2;
        B2.left=C1;
        B2.right=C2;
        System.out.println(maxPathSum(A));
    }
}
