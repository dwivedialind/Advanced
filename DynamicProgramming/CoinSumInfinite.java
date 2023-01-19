package DSAAdvanced.DynamicProgramming;

import java.util.Arrays;

public class CoinSumInfinite {
    public static int coinchange2(int[] A, int B) {
        //we are given a set of coins in A
        //and we have infinite amount of coins for each note in A
        //and we want sum B
        //so this is like no. of subsets with sum==B such that we can choose any element multiple times
        int N=A.length;
        int[][] dp = new int[N][B+1];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
       return coins(dp,A,N-1,B);
    }
    public static int coins(int[][] dp, int[] A, int i, int B){
        if(i<0){
            if(B==0)return 1;
            else
                return 0;
        }
        if(dp[i][B]==-1){
            int a=coins(dp,A,i-1,B);//we don't pick it
            int b= 0;
            if(B>=A[i]){
                //we pick it and stay
               b=coins(dp,A,i,B-A[i]);
            }
            dp[i][B]=(a%1000007+b%1000007)%1000007;
        }
        return dp[i][B];
    }

    public static void main(String[] args) {
        int[] A={18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8};
        int B=458;
        System.out.println(coinchange2(A,B));
    }
}
