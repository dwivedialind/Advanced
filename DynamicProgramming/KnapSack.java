package DSAAdvanced.DynamicProgramming;

import java.util.HashMap;

public class KnapSack {
    public static int solve(int[] A, int[] B, int C) {
        //we are giving A: which has values associated with N elements
        //B: which has weight associated with N elements
        /*
        Brute Force: we can check all the 2^n combination subsets, if weight of subset
        <=C then we can check which has max value.
        T.C=O(2^N)*(N)
         Optimise:
           index:   0 1 2 3 4 5 6 7
       let's say we have an array of 8 elements then we can start from 7th element
       what we have to do: we have to choose elements from 0-7 such that weight sum<=C
       for this we have two choice either we can pick 7th or leave 7th
       Case 1: if we leave 7th element then we have to choose elements from 0 to 6 such that
       sum<=C.
       Case2: if we pick 7th element then we have to choose elements from 0 to 6 such that
       sum<=C-B[7], but this we can do only C>=B[7]
       hence we can solve this by subproblem but we don't know if it's overlapping or not.
       for now we just assume it does have overlapping subproblem.
       hence we use dp
         */
        //here to store dp states we could use hashmap
        /*
        dpState: dp.get("i@k") represents max value subset with weight sum<=k from o to i
        dpexpression:
               a= dp.get(i-1@k)
               if(k>=B[i])
               b=dp.get(i-1@k-B[i])+A[i]
         dpTable:
         HashMap
         final ans: dp.get(i@k)
         */
        //dp table is a hashmap here
        HashMap<String,Integer> dp = new HashMap<>();
        return knapSack(dp,A,B,A.length-1,C);
    }
    public static int knapSack(HashMap<String,Integer> dp, int[] A, int[] B, int i,int k){
        //base condition
        if(i<0) {
             return 0;
        }
        if(!dp.containsKey(i+"@"+k)) {
            int a = knapSack(dp, A, B, i - 1, k);
            int b=Integer.MIN_VALUE;
            if (k >= B[i]) {
                b = knapSack(dp, A, B, i - 1, k - B[i]);
            }
            dp.put(i + "@" + k, Math.max(a, b + A[i]));
        }
            return dp.get(i+"@"+k);
    }

    public static void main(String[] args) {
        int[] A={10,20,30,40};
        int[] B={12,13,15,19};
        int C=10;
        System.out.println(solve(A,B,C));
    }
}

