package DSAAdvanced.ProblemOnTrees;

import DSAAdvanced.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BthSmallestElement {
//We can also do this by morse in order traversal so we don't have to use extra space by stack
    public int kthsmallest(TreeNode A, int B) {
        //we will try to iterate in inorder fashion and when count reaches B then we
        //break
        int count=0;

        TreeNode curr=A;
        Stack<TreeNode> st = new Stack<>();
        while(st.size()>0 || curr!=null){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            count++;
            if(count==B){
               break;
            }
            curr=curr.right;
        }
        return curr.val;
    }
}
