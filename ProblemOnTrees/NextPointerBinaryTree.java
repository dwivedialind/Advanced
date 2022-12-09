package DSAAdvanced.ProblemOnTrees;
class TreeLinkNode {
    int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
public class NextPointerBinaryTree {
    public void connect(TreeLinkNode root) {
    //we have to solve it by constant extra space
        //tree is perfect binary tree

        TreeLinkNode t=root;
    while(t.left!=null){
        TreeLinkNode curr=t;
        while(t!=null){
            t.left.next=t.right;
            if(t.next!=null){
                t.right.next=t.next.left;
            }
            t=t.next;
        }
        t=curr.left;
    }
    }
}
