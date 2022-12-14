package DSAAdvanced.ProblemOnTrees2;

import DSAAdvanced.TreeNode;
import DSAAdvanced.ProblemOnTrees2.Deserealization;
import java.util.*;

public class Serealization {
    public static TreeNode deSerialize(int[] A){
        //we have to get root of treenode from list
        int i=1;
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode root=new TreeNode(A[0]);
        q.add(root);
        while(q.size()>0){
            TreeNode curr=q.peek();
            if(A[i]!=-1){
                curr.left=new TreeNode(A[i]);
                q.add(curr.left);
            }
            if(A[i+1]!=-1){
                curr.right=new TreeNode(A[i+1]);
                q.add(curr.right);
            }
            q.remove();
            i=i+2;
        }
        return root;
    }
    public static ArrayList<Integer> serialize(TreeNode A){
        //we will do serialization using level-order traversal
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode curr=A;
        q.add(curr);
        while(q.size()>0){
            curr = q.peek();
            q.remove();
            //we have to insert both parent and child
            if(curr!=null){
                list.add(curr.val);
                q.add(curr.left);
                q.add(curr.right);

            }else
                list.add(-1);
        }
        return list;
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
        int [] arr= {20,-10,20,-1,-1,-10,-50,-1,-1,-1,-1};
        TreeNode root= deSerialize(arr);
        ArrayList<Integer> res =serialize(A);
        for(int i:res){
            System.out.println(i);
        }
    }
}
