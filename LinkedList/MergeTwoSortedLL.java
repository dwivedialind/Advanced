package DSAAdvanced.LinkedList;

public class MergeTwoSortedLL {
public static Node mergeSortedLL(Node A, Node B ) {
    //we need to merget two sorted LL this we can do by using pointers
    //since we cannnot use extra space we need to get the starting node or head node of sorted LL
    //temp. node for first LL
    Node h = A;
    Node h1 = B;
    //if any on LL is null, then we need not do sort and directly return
    if(h==null) {
        return h1;
    }
    if(h1==null){
        return h;
    }
    //this t will iterate over new LL
    Node t;
    Node rh;
    if(h.data<h1.data){
        rh=h;  t=h; h= h.next;

    }else{
        rh=h1;  t=h1; h1= h1.next;

    }
    while(h!=null && h1!=null){
        if(h.data<h1.data){
            t.next=h;
            t=t.next;
            h=h.next;
        }else{
            t.next=h1;
            t=t.next;
            h1=h1.next;
        }
    }
    //now if any of the LL is not ended
   if(h!=null){
       t.next=h;

    }
   if(h1!=null){
        t.next=h1;

    }
    return rh;


}

    public static void main(String[] args) {
        //1st LL
        Node a = new Node(10);
        Node b = new Node(20); a.next=b;
        Node c = new Node(30); b.next=c;
        Node d = new Node(40); c.next=d;
        //2nd LL
        Node a1 = new Node(5);
        Node b1 = new Node(15); a1.next=b1;
        Node c1 = new Node(25); b1.next=c1;
        Node d1 = new Node(35); c1.next=d1;

        Node h = mergeSortedLL(a1,a);
        while(h!=null){
            System.out.println(h.data);
            h=h.next;
        }
    }
}
