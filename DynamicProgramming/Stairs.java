package DSAAdvanced.DynamicProgramming;

import java.util.Arrays;

public class Stairs {
    public static int climbStairs(int A) {
        //there are two ways to reach A
        //either from A-1 or A-2 ex: 5 we can reach from 4 or 3
        //then we have to find total no. of ways to reach 4 and 3
        //4 we can reach from 3 or 2 there comes overlapping subproblem
        /*
                5
              /   \
             4     3           //overlapping 3
           /   \  /  \
           3   2  2   1

      */
        //we can take dp where
        /*
        dpstate: dp[i]= no. of ways to reach at ith stair
        dp expression : at i we can reach from i-1 or i-2
        if dp[i-1]=x and dp[i-2]=y
        then dp[i]=x+y
        final ans: will be dp[n]
        dptable: dp[0....n] so to store n stairs we need dp of n+1 size
        TC: no. of states* T.C for each state
            n+1*1 =O(N)
         SC: tablesize+stacksize
         = n+n=n

         */
        int[] dp = new int[A+1];
        //we initialise each state with -1 to know if we are visiting it for
        //first time. because no. of ways cannot be -ve
        Arrays.fill(dp,-1);
        return noOfWays(A,dp);
    }
    public static int noOfWays(int i, int[] dp){
        //base condition
        if(i<0){
            return 0;
        }
        if(i==0){
            return 1;
        }
        //Assumption: Our function returns no. of ways to climb stairs
        //main logic
        if(dp[i]==-1){//this means we visited here for first time
            dp[i]=(noOfWays(i-1,dp)%1000000007+noOfWays(i-2,dp)%1000000007)%1000000007;
        }
        return dp[i];
    }

    public static void main(String[] args) {
              int A=7;
        System.out.println(climbStairs(A));
    }
}
