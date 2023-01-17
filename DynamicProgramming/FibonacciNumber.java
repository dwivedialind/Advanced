package DSAAdvanced.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNumber {
    public static int fib(int[] dp, int i){
        //base condition
        if(i<=1){
            return i;
        }
        //Assumption: Our function return fibonacci at i
        //main logic
        if(dp[i]==-1){//we visiting for first time
            dp[i]= fib(dp,i-1)+fib(dp,i-2);
        }
        return dp[i];
    }
    public static void main(String[] args) {
        //we can do fibonacci using dp also
        //we know that fib(N) is sum fib(N-1)+fb(N-2)
        /*
               fib(5)
              /      \
            fib(4)   fib(3)
           /     \       /    \
         fib(3)  fib(2) fib(2) fib(1)
     we can see fib(4) requires fib(3) so if we calculate fib(3) once we can store it
     and we don't have to use it again
        */
/*
       dpstate: dp[i] represents fib(i)
       dpexpression:
       dp[i]=dp[i-1]+dp[i-2]
       final ans: dp[i]
       dptables: dp[i+1]
       T.C:N
       S.C= N+N
       N
 */
        Scanner input= new Scanner(System.in);
        int A=input.nextInt();
        int[] dp = new int[A+1];
        Arrays.fill(dp,-1);
        System.out.println(fib(dp,A));
    }
}
