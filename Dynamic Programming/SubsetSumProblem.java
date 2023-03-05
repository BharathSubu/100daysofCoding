import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=subset-sum-problem-1611555638
public class SubsetSumProblem {
    static Boolean isSubsetSum(int n, int arr[], int sum){
        int dp[][] = new int[n][sum+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(n-1,sum,dp,arr);
    }

    private static Boolean find(int i, int sum, int dp[][], int[] arr) {
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
