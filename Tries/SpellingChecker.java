package DSAAdvanced.Tries;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;


public class SpellingChecker {

    public static int[] solve(String[] A, String[] B) {
        //As we did tries yesterday then we will use that only.
        //first argument is A which is dictionary now we need to convert A into Tries by using Hashmap
        //we need root node
        Node t = new Node();
        //now we iterate through string to develop trie
        for(int i=0;i<A.length;i++){
            String data=A[i];
            insert(t,data);
        }
        //After inserting we search on tries and if found the put 1 or else 0 to result array.
        int[] res = new int[B.length];
        Arrays.fill(res,0);
        for(int i=0;i<B.length;i++){
            if(search(t,B[i])){
                res[i]=1;
            }
        }
        return res;
    }
    public static void insert(Node root, String data){
        //now we have to iterate each character of data
        for(int i=0;i<data.length();i++){
            char c = data.charAt(i);
            //if there is character at that node we don't need to insert
            if(root.hm.containsKey(c)){
                //we move to next node
                root=root.hm.get(c);
            }else{
                //if not we insert
                root.hm.put(c,new Node());
                //and move root to next Node
                root= root.hm.get(c);
            }
        }
        //we also need to take care if word ends at certain node or not
        root.isEnd=true;
    }
    public static boolean search(Node root,String data){
        //we will start looking from root only.
        for(int i=0;i<data.length();i++){
            if(root.hm.containsKey(data.charAt(i))){
                root = root.hm.get(data.charAt(i));
            }else{
                return false;
            }
        }
        //this will return
        return root.isEnd;
    }
    public static void main(String[] args) {
        String[] A = {"tape","bcci"};
        String[] B={"table","cci"};
        System.out.println(Arrays.toString(solve(A,B)));


    }
}
class Node{
    HashMap<Character,Node> hm;
    //this to take care if word ends there
    boolean isEnd;
    Node(){
        hm = new HashMap<>();
        isEnd=false;
    }
}