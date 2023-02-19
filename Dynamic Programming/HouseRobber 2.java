//https://leetcode.com/problems/house-robber/

import javax.imageio.ImageTranscoder;
import java.util.*;

public class HouseRobber {
    //Memoization
    public int memoizationRob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = dp[1] = 0;
        findMax(n-1,dp,n,nums);
        findMax(n-2,dp,n,nums);
        return Math.max(dp[n-1],dp[n-2]);
    }

    private int findMax(int i, int[] dp, int n, int[] nums) {
        if(i < 0) return 0;
        if(dp[i]!=-1) return dp[i];
        int step1 = findMax(i-2,dp,n,nums) + nums[i];
        int step2 = findMax(i-3,dp,n,nums) + nums[i];
        return dp[i] = Math.max(step1,step2);
    }

    //tabulaiton
    public int tabulaitonRob(int[] nums) {
        int n = nums.length;
        if(n==0) return nums[0];
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            int step1 = nums[i] + dp[i-2];
            int step2 = Integer.MIN_VALUE ;
            if(i-3>=0)
            step2 = nums[i] + dp[i-3];
            dp[i] = Math.max(step1,step2);
        }
        return Math.max(dp[n-1],dp[n-2]);
    }


}
