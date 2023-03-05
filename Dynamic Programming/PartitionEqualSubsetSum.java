
//https://leetcode.com/problems/partition-equal-subset-sum/

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum+=i;
        if(sum%2!=0) return false;
        int target = sum/2;
        return isSubsetSum(nums.length, nums,target);
    }
     public Boolean isSubsetSum(int n, int arr[], int sum){
        int dp[][] = new int[n][sum+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(n-1,sum,dp,arr);
    }

    public   Boolean find(int i, int sum, int dp[][], int[] arr) {
        if(sum == 0) return true;
        if(i == 0)
            return arr[0] == sum;

        if(dp[i][sum]!=-1) return dp[i][sum] == 0 ? false : true ;
        boolean notTaken = find(i-1,sum,dp,arr);
        boolean taken = false;
        if(arr[i]<sum) taken = find(i-1,sum-arr[i],dp,arr);
        dp[i][sum] = (taken || notTaken)? 1 : 0;
        return taken || notTaken ;
    }
}
