//https://practice.geeksforgeeks.org/problems/rod-cutting0840/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rod-cutting0840
import java.util.*;

public class RodCutting {
    //memoization
    public int cutRod(int price[], int n) {
        int tPrice = 0;
        for(int i : price) tPrice+=i;
        int dp[][] = new int[n][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(n-1,n,price,dp);
    }

    private int find(int i, int len, int[] price, int[][] dp) {
        if(i == 0){
            int cost = (len/(i+1))*price[i];
            return cost;
        }
        if(dp[i][len] != -1) return dp[i][len];
        int canCut = len/(i+1);
        int cost = 0;
        for (int j = 0; j <= canCut; j++) {
            cost = Math.max(cost , j*price[i] + find(i-1,len-(j*(i+1)),price,dp));
        }
        return dp[i][len] = cost;
    }

}
