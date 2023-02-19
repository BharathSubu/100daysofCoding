//https://practice.geeksforgeeks.org/problems/minimum-cost-path3833/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-cost-path

import java.util.Arrays;

public class MinimumCostPath {
    public int minimumCostPath(int[][] grid) {
        int r= grid.length;
        int c = grid[0].length;
        if(r==1 &&  c==1) return grid[0][0];
        long dp[][] = new long[r][c];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        boolean vis[][] = new boolean[r][c];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));
        findMin(0,0,r,c,dp,vis,grid);
        Arrays.stream(dp).forEach(a->System.out.println(Arrays.toString(a)));
        return (int)dp[0][0];
    }

    private int findMin(int i, int j, int r, int c, long[][] dp, boolean[][] vis, int[][] grid) {

        if(i==r-1 && j == c-1) return grid[i][j];
        if(dp[i][j] != -1) return (int)dp[i][j];
        vis[i][j] = true;
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && !vis[nrow][ncol]) {
                if(dp[i][j] == -1)
                    dp[i][j] =  grid[i][j] + findMin(nrow,ncol,r,c,dp,vis,grid);
                else
                dp[i][j] = Math.min( dp[i][j] , grid[i][j] + findMin(nrow,ncol,r,c,dp,vis,grid));
            }
        }
        vis[i][j]= false;
        return (int)dp[i][j];
    }

}
