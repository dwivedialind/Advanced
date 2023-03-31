package DSAAdvanced.LinkedList;
import DSAAdvanced.LinkedList.InsertInSortedLinkedList;
public class ReverseLL {
    public static Node reverseLL(Node h){
        //we're given head of LL, we need to reverse the LL and return h;
        //No extra space & we cannot change val. of node.
        //we need to keep three pointers.
        //this is reference of head of reverse LL
        if(h.next==null){
            return h;
        }
        Node t=h;
        Node rh=null;
        if(t.next==null){
            t.next=rh;
            rh.next=null;
            return t;
        }

        while(t!=null){
            Node k=t.next;
            t.next=rh;
            rh=t;
            t=k;
        }
        return rh;

    }

    public static void main(String[] args) {
        Node a = new Node(10);
       // Node b = new Node(20); a.next=b;
//        Node c = new Node(30); b.next=c;
//        Node d = new Node(40); c.next=d;
        //reverseLL(a);
     Node h= reverseLL(a);
     Node t=h;
     while(t!=null){
         System.out.println(t.data);
         t=t.next;
     }

    }
}
