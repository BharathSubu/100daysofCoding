//https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem
import java.util.*;
public class PerfectSumProblem {
    //memoization
    int mod = (int)(1e9 + 7);
    public int perfectSum(int arr[],int n, int sum)
    {
        long dp[][] = new long[n][sum+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        int ans =  find(n-1,0,arr,sum,dp);
        return ans;
    }

    private int find(int i, int currsum, int[] arr, int sum, long[][] dp) {
        if(currsum > sum) return 0;
        if(i==0){
            if(currsum+arr[i] == sum && currsum == sum) return 2;
            else if(currsum+arr[i] == sum || currsum == sum) return 1;
            else return 0;
        }
        if(dp[i][currsum] != -1) return (int)dp[i][currsum];
        int take = find(i-1,currsum+arr[i],arr,sum,dp);
        int noTake = find(i-1,currsum,arr,sum,dp);
        dp[i][currsum] = take + noTake;
        dp[i][currsum]%=mod;
        return (int)dp[i][currsum];
    }

    //striver
     int countPartitionsUtil(int ind, int target, int[] arr,int[][] dp){
        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }
        if(dp[ind][target]!=-1)
            return dp[ind][target];
        int notTaken = countPartitionsUtil(ind-1,target,arr,dp);
        int taken = 0;
        if(arr[ind]<=target)
            taken = countPartitionsUtil(ind-1,target-arr[ind],arr,dp);
        return dp[ind][target]= (notTaken + taken);
    }

     int targetSum(int n,int target,int[] arr){
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }
        if(totSum-target<0) return 0;
        if((totSum-target)%2==1) return 0;
        int s2 = (totSum-target)/2;
        int dp[][]=new int[n][s2+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return countPartitionsUtil(n-1,s2,arr,dp);
    }

    //tabulation
     int findWays(int []num, int tar){
        int n = num.length;

        int[][] dp=new int[n][tar+1];

        if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            for(int target= 0; target<=tar; target++){

                int notTaken = dp[ind-1][target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = dp[ind-1][target-num[ind]];

                dp[ind][target]= (notTaken + taken)%mod;
            }
        }
        return dp[n-1][tar];
    }

     int tabulationTargetSum(int n, int target,int[] arr){
        int totSum = 0;
        for(int i=0; i<n;i++){
            totSum += arr[i];
        }
        if(totSum-target <0 || (totSum-target)%2==1 ) return 0;
        return findWays(arr,(totSum-target)/2);
    }

}
