//https://leetcode.com/problems/target-sum/submissions/904803604/

import java.util.*;

public class TargetSum {
    //memoizaiton
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int maxsum = 0;
        for(int i : nums) maxsum+=i;
        int dp[][] =  new int[n][2*(maxsum+1)];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(0,0,n,dp,nums,target,maxsum);
    }
    private int find(int i, int sum, int n , int[][] dp, int[] nums,int target,int maxsum) {
        if (i == n) {
            if (sum == target)
                return 1;
            return 0;
        }
        int psum;
        if (sum < 0) {
            psum = maxsum + (Math.abs(sum));
        } else psum = sum;
        if (dp[i][psum] != -1) return dp[i][psum];
        dp[i][psum] = 0;
        int minus = find(i + 1, sum - nums[i], n, dp, nums, target, maxsum);
        int plus = find(i + 1, sum + nums[i], n, dp, nums, target, maxsum);
        if (minus != 0) dp[i][psum] += minus;
        if (plus != 0) dp[i][psum] += plus;
        return dp[i][psum];
    }
    //stiver


}
