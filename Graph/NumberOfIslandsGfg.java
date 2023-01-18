
//https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1

import java.util.*;

public class NumberOfIslandsGfg {

    int r = -1;
    int c = -1;

    public int numIslands(char[][] grid) {
        int count = 0;

        r= grid.length;
        c = grid[0].length;

        boolean [][] vis = new boolean[r][c];

        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i , j , vis,grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, boolean[][] vis, char[][] grid) {
        int drow[] = {-1, 0, +1, 0, -1, -1, +1, +1};
        int dcol[] = {0, 1, 0, -1 , +1, -1, +1, -1};
        vis[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                dfs(nrow, ncol, vis, grid);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands sol = new NumberOfIslands();
        char grid[][] = {{'0','1'},{'1','0'},{'1','1'},{'1','0'}};
        System.out.println(sol.numIslands(grid));
    }
}
