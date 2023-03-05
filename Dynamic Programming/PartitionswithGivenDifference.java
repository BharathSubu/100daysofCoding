//https://practice.geeksforgeeks.org/problems/partitions-with-given-difference/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=partitions-with-given-difference
import java.util.*;
public class PartitionswithGivenDifference {

    int mod = (int)(1e9 + 7);
    public int countPartitions(int n, int d, int arr[]){
        int sum =0;
        for(int i :arr) sum+=i;
        int target = sum + d;
        if(target < 0 || target%2!=0 || sum<d) return 0;
        target/=2;
        return perfectSum(arr,n,sum-target);
    }

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
}
