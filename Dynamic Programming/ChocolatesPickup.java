//https://practice.geeksforgeeks.org/problems/chocolates-pickup/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=chocolates-pickup

import java.util.*;

public class ChocolatesPickup {
    public int solve(int n, int m, int grid[][]){
        int dp[][][] = new int[n][m][m];
        Arrays.stream(dp).forEach(a->Arrays.stream(a).forEach(b->Arrays.fill(b,-1)));
        int res = findMax(0,0,m-1,n,m,dp,grid);
        return res;
    }

    private int findMax(int i, int j1, int j2, int r, int c, int[][][] dp, int[][] grid) {
        if(i < 0 || j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) return Integer.MIN_VALUE;
        if(i == r-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int ans = Integer.MIN_VALUE;
        for (int j = -1; j < 2; j++) {
            for (int k = -1; k < 2; k++) {
                int maxi;
                if(j1 == j2) maxi = grid[i][j1] + findMax(i+1, j1 + j, j2 + k,r,c,dp,grid);
                else maxi = grid[i][j1] + grid[i][j2] + findMax(i+1, j1 + j, j2 + k,r,c,dp,grid);
                ans = Math.max(maxi,ans);
            }
        }
        return dp[i][j1][j2] = ans;
    }
}
