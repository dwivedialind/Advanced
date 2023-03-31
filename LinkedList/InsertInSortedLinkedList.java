package DSAAdvanced.LinkedList;

public class InsertInSortedLinkedList {
    public static void insert(Node h, int x){
        //to insert in LL we can iterate on array and at any point, if we found next node data is >x insert there.
        if(h==null){//if h is null we can put new node at head only.
            h=new Node(x);
            return;
        }
        if(h.data>x){
            Node t=h;
            h=new Node(x);
            h.next=t;
        }
        //we don't want to disturb head, so take temp reference to iterate LL.
        Node t = h;
        //now we can iterate till t.next.data>x and t!=null.
        while(t.next!=null && (t.next.data<x)){
            t= t.next;
        }
        //we need to get next node in some var. so while insert we don't loose the chain
        Node t1 = t.next;
        //now insert at t.next
        t.next=new Node(x);
        //now move to inserted node
        t=t.next;
        //now make connection
        t.next=t1;
    }
    public static void printLL(Node h){
        //here we are printing entire node
        while(h!=null){
            System.out.println(h.data);
            h=h.next;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20); a.next=b;
        Node c = new Node(30); b.next=c;
        Node d = new Node(40); c.next=d;
        //node to insert
        insert(a,45);
        printLL(a);
    }
}
