package DSAAdvanced.Hashing2;

import java.util.ArrayList;
import java.util.HashSet;

public class Unique2DPoints {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        //first we store all the points in hashset in String format
        HashSet<String> hs = new HashSet<>();
        int i=0;
        int n=A.size();
        while(i<n){
            String S=A.get(i).get(0)+"@"+A.get(i).get(1);
            hs.add(S);
            i++;
        }
        return hs.size();
    }
}
