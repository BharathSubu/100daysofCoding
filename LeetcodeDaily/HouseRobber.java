//https://leetcode.com/problems/house-robber/

import java.util.*;

public class HouseRobber {
    public int rob(int[] nums) {
        long dp[] = new long[nums.length];
        Arrays.fill(dp,-1);
        long res = Math.max(findBestHouses(0,nums,dp),findBestHouses(1,nums,dp));
        return (int) res;
    }

    long findBestHouses(int i, int[] nums, long[] dp) {
        if(i >= nums.length) return 0;
        if(dp[i] == -1)  dp[i] = nums[i] + Math.max(findBestHouses(i+2,nums,dp),findBestHouses(i+3,nums,dp));
        return dp[i];
    }
}
