//https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=knapsack-with-duplicate-items
import java.util.*;
public class KnapsackWithDuplicateItems {
    //memoization
    static int knapSack(int n, int w, int val[], int wt[])
    {
        int dp[][] = new int [n][w+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(n-1,w,val,wt,dp);
    }

    private static int find(int i, int w, int[] val, int[] wt, int[][] dp) {
        if(i == 0){
            if(w >= wt[i]) return val[i]*(w/wt[i]);
            else return 0;
        }
        if(dp[i][w]!=-1) return dp[i][w];
        int take = 0;
        if(w >= wt[i]) take = val[i] + find(i,w-wt[i],val,wt,dp);
        int notTake = find(i-1,w,val,wt,dp);
        return dp[i][w] = Math.max(take,notTake);
    }
    
}
