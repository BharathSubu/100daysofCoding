//https://leetcode.com/problems/minimum-path-sum/
import java.util.*;
public class MinimumPathSum {
    //memoization
    public int memoizationMinPathSum(int[][] grid) {
        int r= grid.length;
        int c = grid[0].length;
        if(r==1 &&  c==1) return grid[0][0];
        int dp[][] = new int[r][c];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
        findMin(0,0,r,c,dp,grid);
        return dp[0][0];
    }

    private int findMin(int i, int j, int r, int c, int[][] dp, int[][] grid) {
        if(i == r-1 && j == c-1) return grid[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int drow[] = { +1, 0};
        int dcol[] = { 0, +1};
        for (int k = 0; k < 2; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c ) {
                dp[i][j] = Math.min(dp[i][j],grid[i][j]+ findMin(nrow,ncol,r,c,dp,grid));
            }
        }
        return dp[i][j];
    }

    //tabulation
    public int tabulationMinPathSum(int[][] grid) {
        int r= grid.length;
        int c = grid[0].length;
        if(r==1 &&  c==1) return grid[0][0];
        int dp[][] = new int[r][c];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int up = Integer.MAX_VALUE , left = Integer.MAX_VALUE;
                if(i>0) up = grid[i][j] + dp[i-1][j];
                if(j>0) left = grid[i][j] + dp[i][j-1];
                dp[i][j] = Math.min(up,left);
            }
        }
        return dp[r-1][c-1];
    }
}
