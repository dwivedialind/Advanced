package DSAAdvanced.ProblemOnTrees;
import DSAAdvanced.TreeNode;


public class MorseInOrderTraversal {
    public static void morstInTraversal(TreeNode A){
        TreeNode curr=A;
 while(curr!=null){
        if(curr.left==null){
            System.out.println(curr.val);
            curr=curr.right;
        }else {
            TreeNode t = curr.left;
            while (t.right != null && t.right != curr) {
                t = t.right;
            }
            if (t.right == null) {
                t.right = curr;
                curr = curr.left;
            } else {
                System.out.println(curr.val);
                curr = curr.right;
            }
        }
        }


    }

    public static void main(String[] args) {
        TreeNode A= new TreeNode(2);
        TreeNode B= new TreeNode(1);
        TreeNode C= new TreeNode(3);
        A.left=B;
        A.right=C;
        morstInTraversal(A);
    }
}
