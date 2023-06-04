//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
import java.util.*;
public class MinimumCostToCutAStick {

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int dp[][] = new int[m+1][m+1];
        Arrays.sort(cuts);
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(0,m-1,n,dp,cuts);
    }

    int find(int i , int j , int n ,int dp[][] , int cuts[]){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int start = i-1 == -1 ? 0 : cuts[i-1];
        int end = j+1 == cuts.length ? n : cuts[j+1];
        int sum = Integer.MAX_VALUE;
        for(int k = i ; k <= j ; k++){
            sum = Math.min(sum , (end - start) + find(i,k-1,n,dp,cuts) + find(k+1,j,n,dp,cuts));
        }
        return dp[i][j] = sum;
    }
}
