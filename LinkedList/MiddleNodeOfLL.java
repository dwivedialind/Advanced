package DSAAdvanced.LinkedList;

public class MiddleNodeOfLL {
    public static Node midOfLL(Node h){
      //we can iterate on a LL get it's length and then go to middle
        //this will take 2 loops T.C=O(N) S.C=O(1)
        //now to do this is 1 loop
        /*
        we can do this in one loop using two-pointers, slow and fast method
        take s & f and initialize them at head
        move f=f.next.next // fast takes 2 steps
        move s=s.next // slow takes 1 step
        obs 1: when f.next = null, stop & return s
        obs 2: when f.next.next = null, stop and return s
        //if there are 2 mids, we need to return 1st mid.
         */
        Node s=h;
        Node f=h;
        while(f.next!=null && f.next.next !=null){
            s=s.next;//one step
            f=f.next.next;//two step
        }
        return s;
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20); a.next=b;
        Node c = new Node(30); b.next=c;
        Node d = new Node(40); c.next=d;
        Node e = new Node(50); d.next=e;
        Node f = new Node(60); e.next=f;
        Node g = new Node(70); f.next=g;
        Node i = new Node(80); g.next=i;
        System.out.println(midOfLL(a).data);
    }
}
