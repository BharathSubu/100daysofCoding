//https://leetcode.com/problems/longest-increasing-subsequence/description/
import java.util.*;
public class LongestIncreasingSubsequence {
    //memoization
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(0,-1,n,dp,nums);
    }

    private int find(int i, int prev , int n ,int[][] dp, int[] nums) {
        if(i == n){
             return 0;
        }
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int take = Integer.MIN_VALUE , noTake = Integer.MIN_VALUE;
        noTake = find(i+1,prev,n,dp,nums);
        if(prev ==-1 || nums[prev] < nums[i]){
             take = 1 + find(i+1,i,n,dp,nums);
        }
        return dp[i][prev+1] = Math.max(take,noTake);
    }

    //tabulation
    public int tabulationLengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for (int i = 0; i <= n ; i++) {
            dp[n][i] = 0;
        }
        for (int i = n-1; i >=0; i--) {
            for (int j = i-1; j >=-1 ; j--) {
                int notake = dp[i+1][j+1];
                int take = Integer.MIN_VALUE;
                if(j == -1 || nums[j] < nums[i]) take = 1 + dp[i+1][i+1];
                dp[i][j+1] = Math.max(take,notake);
            }
        }
        return dp[0][0];
    }

    //approach2
    public int app2LengthofLIS(int [] nums){
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] ={0,1,0,3,2,3};
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        System.out.println(sol.lengthOfLIS(arr));
    }
}
