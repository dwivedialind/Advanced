package DSAAdvanced.Arrays.Arrays1;

public class MaxSumContguousSubArray {
    public static int maxSubArray(final int[] A) {
        //we can solve this in O(N) we can take sum variable, and if at any point S get
        //belows 0 we will start subarray from next point
        int sum=0;
        int maxSub=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
          maxSub=Math.max(sum,maxSub);
          if(sum<=0){
              sum=0;
          }
        }
        return maxSub;
    }

    public static void main(String[] args) {
        int[] A={-3,2};
        System.out.println(maxSubArray(A));
    }
}
