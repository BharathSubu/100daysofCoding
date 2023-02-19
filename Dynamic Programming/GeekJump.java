//https://practice.geeksforgeeks.org/problems/geek-jump/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geek-jump

import java.util.*;

public class GeekJump {
    public int tabularionMinimumEnergy(int arr[],int n){
        //tc - o(n) ; sc - o(n)
        int dp[] = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n) {
                int diff = Math.abs(arr[i] - arr[i + 1]);
                diff += dp[i];
                dp[i + 1] = Math.min(diff, dp[i + 1]);
            }
            if (i + 2 < n) {
                int diff = Math.abs(arr[i] - arr[i + 2]);
                diff += dp[i];
                dp[i + 2] = Math.min(diff, dp[i + 2]);
            }
        }
        return dp[n-1];
    }

    public int memoizationMinimumEnergy(int arr[],int n){
       int dp[] = new int[n];
       Arrays.fill(dp,-1);
       return findMin(n-1,dp,arr,n);
    }

    private int findMin(int i, int[] dp, int[] arr, int n) {
        if(i==0) return 0;
        if(dp[i]!=-1) return dp[i];
        int one = findMin(i-1,dp,arr,n) + Math.abs(arr[i]-arr[i-1]);
        int  two = Integer.MAX_VALUE;
        if(i-2>=0)
        two = findMin(i-2,dp,arr,n) + Math.abs(arr[i]-arr[i-2]);
        return dp[i] = Math.min(one,two);
    }

    public static void main(String[] args) {
       int n = 6;
       int arr[] = { 4 ,8 ,3 ,10, 4 ,4};
       GeekJump sol = new GeekJump();
       System.out.println(sol.memoizationMinimumEnergy(arr,n));
    }

}
