package DSAAdvanced.LinkedList;
class Node{
    int data;//this will holds data at the node
    Node next;//this will hold address of the next node
    Node(int x){//constructor is to initialize data member of class
        data=x;
        next=null;
    }

}
public class BasicLinkedList {
    //we're giving head node of linked list and get size of linked list.
    public static int size(Node h){
        //this var. is to store size
        int c=0;
        while(h!=null){
            c++;
            h=h.next;
        }
        return c;
    }
    public static void main(String[] args) {
         Node a = new Node(20);
         Node b = new Node(20); a.next=b;
         Node c = new Node(20); b.next=c;
         Node d = new Node(20); c.next=d;
        System.out.println(size(a));

    }
}
