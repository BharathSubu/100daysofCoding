//https://leetcode.com/problems/detect-cycles-in-2d-grid/

import java.util.*;

public class DetectCycleIn2DGrid {

    int r = -1;
    int c = -1;
    public boolean containsCycle(char[][] grid) {
        r = grid.length;
        c = grid[0].length;
        boolean [][] vis = new boolean[r][c];
        Arrays.stream(vis).forEach((a)->Arrays.fill(a, false));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!vis[i][j]) {
                    boolean ans = dfs(-1 , -1 , i, j, vis, grid, grid[i][j]);
                    if (ans) return ans;
                }
            }
        }
        return false;
    }
    boolean dfs(int pi ,int pj ,int i, int j, boolean[][] vis ,char [][] grid , char currChar) {
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == currChar)  {
                if(vis[nrow][ncol] && (ncol != pj && nrow != pj) ) return true;
                if(!vis[nrow][ncol])
                {
                    boolean ans = dfs( i, j , nrow, ncol, vis, grid, currChar);
                    if (ans) return ans;
                }
            }
        }
        return false;
    }
}
