package DSAAdvanced.Hashing2;

import java.util.ArrayList;
import java.util.HashSet;

public class CountRectangle {
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
            //first we store all the points in hashset in String format
        HashSet<String> hs = new HashSet<>();
        int i=0;
        int n=A.size();
        while(i<n){
            String S=A.get(i)+"@"+B.get(i);
            hs.add(S);
            i++;
        }
       //this will store if there exists rectangle
       int ans=0;
        //j will take 1st point
        for(int j=0;j<n-1;j++){
            //k will take next point
            for(int k=j+1;k<n;k++){
                int x1=A.get(j);
                int y1=B.get(j);
                int x2=A.get(k);
                int y2=B.get(k);
                //if both x and y points are not same then both points are diagonal points
                if(x1!=x2&&y1!=y2){
                    //now we search if B and D are in given points that in hashset
                    /*
                       (x1,y2)//B                  (x2,y2)//C


                        (x1,y1)//A                 (x2,y1)//D
                     */
                    String p1=x1+"@"+y2;
                    String p2=x2+"@"+y1;
                    if(hs.contains(p1)&&hs.contains(p2)){
                        ans++;
                    }
                }

            }
        }
        return ans/2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>();
        A.add(1);A.add(1);A.add(2);A.add(2);//A.add(3);A.add(3);
        ArrayList<Integer> B= new ArrayList<>();
        B.add(1);B.add(2);B.add(1);B.add(2);//B.add(1);B.add(2);
        System.out.println(solve(A,B));
    }
}
