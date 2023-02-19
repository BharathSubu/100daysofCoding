//https://leetcode.com/problems/max-area-of-island/
import java.util.*;
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        DSU dsu = new DSU(r*c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]==0) continue;
                int drow[] = {-1, 0, +1, 0};
                int dcol[] = {0, 1, 0, -1};
                for (int k = 0; k < 4; k++) {
                    int nrow = i + drow[k];
                    int ncol = j + dcol[k];
                    if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == 1 ) {
                        int u = encode(i,j,r,c);
                        int v = encode(nrow,ncol,r,c);
                        dsu.unionBySize(u,v);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < r * c; i++) {
            int row = i/c;
            int col = i%c;
            if(grid[row][col]!=0){
                max = Math.max(max,dsu.size.get(i));
            }
        }
        return max;
    }
    int encode(int i,int j,int r,int c){
        int ans = (i*c) + j;
        return ans;
    }
}
