//https://practice.geeksforgeeks.org/problems/minimal-cost/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimal-cost
import java.util.*;
public class MinimalCost {
    //Memoization
    public int memoizationMinimizeCost(int arr[],int n,int k){
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return findMin(n-1,dp,k,arr,n);
    }

    private int findMin(int i, int[] dp, int k, int[] arr, int n) {
        if(i == 0) return 0;
        if(dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= k && (i-j) >= 0; j++) {
            min = Math.min(min,findMin(i-j,dp,k,arr,n) + Math.abs(arr[i] - arr[i-j]));
        }
        dp[i] = min;
        return min;
    }
    //tabulation
    public int tabulationMinimizeCost(int arr[],int n,int k){
        long dp[] = new long[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1] = 0;
        for (int i = n-1; i >= 0 ; i--) {
            for (int j = 1; j <= k && (i-j) >= 0; j++) {
                dp[i-j] = Math.min(dp[i-j],Math.abs(arr[i]-arr[i-j]) + dp[i]);
            }
        }
        return (int)dp[0];
    }
}
