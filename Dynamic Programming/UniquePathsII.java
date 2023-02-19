//https://leetcode.com/problems/unique-paths-ii/description/

import java.util.*;

public class UniquePathsII {
    //memoization
    long mod = (int)Math.pow(10,9) + 7;
    public int memoizationUniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        if(r==1 && c==1 ) {
            if(obstacleGrid[0][0] == 1) return 0;
            return 1;
        }
        long dp[][] = new long[r][c];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,0));
        findMin(0,0,r,c,dp,obstacleGrid);
        return (int)dp[0][0];
    }

    private int findMin(int i, int j, int r, int c, long[][] dp, int[][] obstacleGrid) {
        if(i == r-1 && j == c-1) return 1;
        if(dp[i][j]!=0) return (int)dp[i][j];
        int drow[] = { +1, 0};
        int dcol[] = { 0, +1};
        for (int k = 0; k < 2; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c  && obstacleGrid[nrow][ncol] == 0) {
                dp[i][j] += findMin(nrow,ncol,r,c,dp,obstacleGrid);
            }
        }
        return (int)dp[i][j];
    }

    //Tabulation
    public int tabulationUniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        long dp[][] = new long[r][c];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,0));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i > 0 && j>0 && obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                long up = 0;
                if(i-1 >= 0){
                    up = (int)dp[i-1][j];
                }

                long down = 0;
                if(j-1 >= 0){
                    down = (int)dp[i][j-1];
                }
                dp[i][j] = up+down;
                dp[i][j]%=mod;
            }
        }
        return (int)dp[r-1][c-1];
    }
}
