//https://leetcode.com/problems/count-sub-islands/

import java.util.*;

public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int r = grid1.length;
        int c = grid1[0].length;
        DSU dsu = new DSU(r*c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid1[i][j]==0) continue;
                int drow[] = {-1, 0, +1, 0};
                int dcol[] = {0, 1, 0, -1};
                for (int k = 0; k < 4; k++) {
                    int nrow = i + drow[k];
                    int ncol = j + dcol[k];
                    if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid1[nrow][ncol] == 1 ) {
                        int u = encode(i,j,r,c);
                        int v = encode(nrow,ncol,r,c);
                        dsu.unionBySize(u,v);
                    }
                }
            }
        }
        int count = 0;
        boolean vis[][] = new boolean[r][c];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid2[i][j]==1 && grid1[i][j]==1 && !vis[i][j]) {
                    int parent = dsu.findUPar(encode(i,j,r,c));
                    if(dfs(i,j,r,c,vis,dsu,grid2,grid1,parent)) count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int i, int j, int r, int c, boolean[][] vis, DSU dsu, int[][] grid2,int grid1[][],int parent) {
        vis[i][j] = true;
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        boolean isFalse = true;
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && !vis[nrow][ncol] && grid2[nrow][ncol] == 1 ){
                if(dsu.findUPar(encode(nrow,ncol,r,c))!=parent) {
                    isFalse = false;
                };
                if(grid1[nrow][ncol] != grid2[nrow][ncol]) {
                    isFalse = false;
                }
                boolean ans = dfs(nrow,ncol,r,c,vis,dsu,grid2,grid1,parent);
                if(!ans) {
                    isFalse = false;
                };
            }
        }
        return isFalse;
    }

    int encode(int i,int j,int r,int c){
        int ans = (i*c) + j;
        return ans;
    }
}
