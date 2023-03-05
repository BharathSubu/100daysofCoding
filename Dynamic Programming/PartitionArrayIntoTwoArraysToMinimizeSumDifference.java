//https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-sum-partition3317
import java.util.*;
public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public int minDifference(int nums[], int n){
        int target = 0;
        for(int i : nums){
             target+=i;
        }
        boolean[][] dp = new boolean[n][target+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target)
            dp[0][target] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
               boolean nonTaken = dp[i-1][j];
               boolean taken = false;
               if(nums[i] <= j) taken = dp[i-1][j-nums[i]];
               dp[i][j] = taken || nonTaken;
            }
        }
        int mini = (int)1e9;
        for (int i = 0; i <= target; i++) {
            if (dp[n - 1][i] == true) {
                int diff = Math.abs(i - (target - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
}
