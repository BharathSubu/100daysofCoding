//https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1
import java.util.*;
public class UnitArearOfLargest1 {
    public int findMaxArea(int[][] grid)
    {
        int r = grid.length;
        int c = grid[0].length;
        boolean vis[][] = new boolean[r][c];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 1 && !vis[i][j]){
                    count = Math.max(count,dfs(i,j,r,c,vis,grid));
                }
            }
        }
        return count;
    }

    private int dfs(int i, int j, int r, int c, boolean[][] vis, int[][] grid) {
        int count = 1;
        vis[i][j] = true;
        int drow[] = {-1, 0, +1, 0, -1, -1, +1, +1};
        int dcol[] = {0, 1, 0, -1 , +1, -1, +1, -1};
        for (int k = 0; k < 8; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                count+=dfs(nrow,ncol,r,c,vis,grid);
            }
        }
        return count;
    }
}
