//https://leetcode.com/problems/pacific-atlantic-water-flow/description/

import java.util.*;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        int r = mat.length;
        int c =mat[0].length;
        boolean vis[][] = new boolean[r][c];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));

        int [][] count = new int[r][c];
        Arrays.stream(count).forEach(a->Arrays.fill(a,0));

        //From indian
        for (int i = 0; i < c; i++) {
            if(!vis[0][i]) dfs(0,i,r,c,count,vis,mat);
        }
        for (int i = 0; i < r; i++) {
            if(!vis[i][0]) dfs(i,0,r,c,count,vis,mat);
        }

        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));
        //From Arabic
        for (int i = 0; i < r; i++) {
            if(!vis[i][c-1]) dfs(i,c-1,r,c,count,vis,mat);
        }
        for (int i = 0; i < c; i++) {
            if(!vis[r-1][i]) dfs(r-1,i,r,c,count,vis,mat);
        }
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(count[i][j] == 2) {
                    List<Integer> g = new ArrayList<>();
                    Collections.addAll(g,i,j);
                    res.add(g);
                }
            }
        }
        return res;
    }
    private void dfs(int i, int j, int r, int c, int [][] count, boolean[][] vis, int[][] mat) {
        vis[i][j] = true;
        count[i][j]+=1;
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && !vis[nrow][ncol] && (mat[nrow][ncol] >= mat[i][j])) {
                dfs(nrow,ncol,r,c,count,vis,mat);
            }
        }
    }
}
