//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=0-1-knapsack-problem0945
import java.util.*;
public class Knapsack {
    //memoization
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int dp[][] = new int[n][W+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(n-1,W,wt,val,dp);
    }

    private static int find(int i, int w, int[] wt, int[] val, int[][] dp) {
        if(i == 0){
            if(w >= wt[i]) return val[i];
            else return 0;
        }
        if(dp[i][w]!=-1) return dp[i][w];
        int take = 0;
        if(w >= wt[i]) take = val[i] + find(i-1,w-wt[i],wt,val,dp);
        int notTake = find(i-1,w,wt,val,dp);
        return dp[i][w] = Math.max(take,notTake);
    }

    //tabulation
    static int tabulationKnapSack(int W, int wt[], int val[], int n)
    {
        int dp[][] = new int[n][W+1];
        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = val[0];
        }
        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){
                int notTaken = 0 + dp[ind-1][cap];
                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind-1][cap - wt[ind]];
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }
        return dp[n-1][W];
    }
}
