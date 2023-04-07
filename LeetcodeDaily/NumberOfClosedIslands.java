//https://leetcode.com/problems/number-of-closed-islands/description/

import java.util.*;
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int r = grid.length , c = grid[0].length;
        boolean vis[][] = new boolean[r][c];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));
        for (int i = 0; i < r; i++) {
           if(grid[i][0] == 0) dfs(i,0,r,c,vis,grid);
           if(grid[i][c-1] == 0) dfs(i,c-1,r,c,vis,grid);
        }
        for (int i = 0; i < c; i++) {
            if(grid[0][i] == 0) dfs(0,i,r,c,vis,grid);
            if(grid[r-1][i] == 0) dfs(r-1,i,r,c,vis,grid);
        }
        int count = 0;
        for (int i = 1; i < r-1; i++) {
            for (int j = 1; j < c-1; j++) {
                if(grid[i][j] == 0 && !vis[i][j]) {
                    count++;
                    dfs(i,j,r,c,vis,grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j,int r, int c,boolean[][] vis, int[][] grid) {
        vis[i][j] = true;
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == 0 && !vis[nrow][ncol]) {
                dfs(nrow,ncol,r,c,vis,grid);
            }
        }
    }

}
