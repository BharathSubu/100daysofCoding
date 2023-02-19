//https://practice.geeksforgeeks.org/problems/chocolates-pickup/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=chocolates-pickup
import java.util.*;
public class HouseRobberII {
    //same as house robber but here the first and second is adjacent
    public int rob(int[] nums) {
        int ans1 = tabulaitonRob(nums,1, nums.length);
        int ans2 = tabulaitonRob(nums,0, nums.length-1);
        return Math.max(ans1,ans2);
    }

    public int tabulaitonRob(int[] nums , int start , int end) {
        int n = nums.length - 1;
        if(n== 1) return nums[start];
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[start] = nums[start];
        dp[start+1] = nums[start+1];
        for (int i = start + 2; i < n; i++) {
            int step1 = nums[i] + dp[i-2];
            int step2 = Integer.MIN_VALUE ;
            if(i-3>=0)
                step2 = nums[i] + dp[i-3];
            dp[i] = Math.max(step1,step2);
        }
        return Math.max(dp[n-1],dp[n-2]);
    }
}
