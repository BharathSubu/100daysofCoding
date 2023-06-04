//https://practice.geeksforgeeks.org/problems/partition-array-to-k-subsets/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
import java.util.*;
public class PartitionArrayToKSubsets {
    public boolean isKPartitionPossible(int nums[], int n, int k)
    {
        int target = 0;
        int max = nums[0];
        for(int i = 0;i<nums.length;i++) {
            target+=nums[i];
            max = Math.max(max,nums[i]);
        }
        if(target%k != 0 || target < max) return false;
        target/=k;
        int dp[][] = new int[(int)Math.pow(2,nums.length)][target+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(0,target,target,nums,dp);
    }

    boolean find(int i , int j ,int target, int nums[] , int dp[][]){
        if(i == dp.length - 1 && j == 0) return true;
        if(i == dp.length - 1) return false;
        if(j == 0) j = target;
        if(dp[i][j] != -1) return dp[i][j] == 1;
        boolean ans = false;

        for(int k = 0 ; k < nums.length ; k++){
            if(j - nums[k] >= 0 &&  ( i & 1<<k )==0){
                int nextval = i | (1<<k);
                ans = ans || find(nextval,j-nums[k],target,nums,dp);
            }
            if(ans) break;
        }

        dp[i][j] = (ans == true) ? 1 : 0;
        return ans;
    }
}
