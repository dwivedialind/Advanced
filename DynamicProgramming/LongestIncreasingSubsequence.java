package DSAAdvanced.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    //find the longest increasing subsequence of a given array of integers A
    public static int lis(final int[] A) {
        //we are going to solve this code iteratively because if we do pick or leave
        //when we're picking we don't know if last element in subsequence is < or not
        /*
        so we are saying dp[i] contains length of max subsequence with subsequence ending at A[i]
        dpExpression:
  */
        int N=A.length;
        //this is dp where we store all dp[i]
        int[] dp = new int[N];
        //Arrays.fill(dp,-1);
        //we will fill dp with invalid value so that we know if we are visiting it for first time
        for(int i=0;i<N;i++){
            //this will store max subsequence present before
            int val=0;
           //now we iterate for all possible dp before i and if last ele. of that subsequence is smaller than A[i] then it can be possible increasing subsequence
           for(int j=i-1;j>=0;j--){
               if(A[j]<A[i]){
                   val = Math.max(val,dp[j]);
               }
           }
           //+1 for element at A[i]
           dp[i]=val+1;
        }
        //iterate over dp to get max length subsequence because it may not end at N-1
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
           max=Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A={14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78 };
        System.out.println(lis(A));
    }
}
