package DSAAdvanced.Hashing2;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CommonElements {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        //first we store array A in treemap
        TreeMap<Integer,Integer> hm1 = new TreeMap<>();
        for(int i:A){
            if(hm1.containsKey(i)){
                int of=hm1.get(i);
                int nf=of+1;
                hm1.replace(i,nf);
            }else
                hm1.put(i,1);
        }
        //next we store array B in treemap
        TreeMap<Integer,Integer> hm2 = new TreeMap<>();
        for(int i:B){
            if(hm2.containsKey(i)){
                int of=hm2.get(i);
                int nf=of+1;
                hm2.replace(i,nf);
            }else
                hm2.put(i,1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        //now we iterate over Treemap hm1
        for(Map.Entry<Integer,Integer> entry: hm1.entrySet()){
            //now if hm2 contains hm1 and element then we check frequency diff
            if(hm2.containsKey(entry.getKey())){
                //frequency of that element in hm2
                int a=hm2.get(entry.getKey());
                //frequency of that element in hm1
                int b=entry.getValue();
                int S=Math.min(a,b);
                while(S!=0){
                    ans.add(entry.getKey());
                    S--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>();
        A.add(1);A.add(2);A.add(2);A.add(1);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(2);B.add(3);B.add(1);B.add(2);
        System.out.println(solve(A,B));
    }
}
