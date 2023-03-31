package DSAAdvanced.LinkedList;

public class ReverseFirstKNodes {
    public static Node reverseK(Node h,int k){
        //we need to reverse first k nodes only
        /*ex:
        1 2 3 4 5 6 7 k=4
        4 3 2 1 5 6 7
        there can be two cases for K>0
        1. k>no. of nodes : reverse entire list
        2. k<no. of nodes: reverse only k nodes
         */
        if(h==null){
            return h;
        }
       Node t = h;
        //we need first node
        Node f = h;
       Node rh = null;
       while(t!=null && k!=0){
           Node nn=t.next;
           t.next=rh;
           rh=t;
           t=nn;
           k--;
       }
       if(t!=null){
           f.next=t;
       }
       return rh;
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20); a.next=b;
        Node c = new Node(30); b.next=c;
        Node d = new Node(40); c.next=d;
        Node h= reverseK(a,5);
        Node t =h;
        while(t!=null){
            System.out.println(t.data);
            t = t.next;
        }
    }
}
