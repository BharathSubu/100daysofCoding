//https://practice.geeksforgeeks.org/problems/96161dfced02d544fc70c71d09b7a616fe726085/1
import java.util.*;
public class UniquePathInGrid {
    static int uniquePaths(int r, int c, int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 0) return 0;
        long dp[][] = new long[r][c];
        int mod = (int)(1e9 + 7);
        Arrays.stream(dp).forEach(a->Arrays.fill(a,0));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if( obstacleGrid[i][j] == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                long up = 0;
                if(i > 0){
                    up = dp[i-1][j];
                }

                long down = 0;
                if(j > 0){
                    down = dp[i][j-1];
                }
                dp[i][j] = (up+down)%mod;

            }
        }
        return (int)dp[r-1][c-1];
    }
}
