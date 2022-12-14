package DSAAdvanced.ProblemOnTrees2;
import DSAAdvanced.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

public class Deserealization {
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

    public static void main(String[] args) {
         int [] A= {20,-10,20,-1,-1,-10,-50,-1,-1,-1,-1};
         TreeNode root = deSerialize(A);
    }
}
