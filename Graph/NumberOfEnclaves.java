// https://leetcode.com/problems/number-of-enclaves/

import java.util.*;

class NumberOfEnclaves {

    int r = -1, c = -1;
    int noOfOnes = 0;

    public int numEnclaves(int[][] grid) {
        r = grid.length;
        c = grid[0].length;

        noOfOnes = 0;

        ArrayList<CoOrd> lst = new ArrayList<>();

        boolean [][] vis = new boolean[r][c];
        Arrays.stream(vis).forEach((a)->Arrays.fill(a, false));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 1){
                    noOfOnes++;
                    if(i==0 || i == r-1 || j== 0 || j == c -1){
                        lst.add(new CoOrd(i, j));
                    }
                }
                else{
                    vis[i][j] = true;
                }
            }
        }
        // System.out.println(noOfOnes++);
        for (CoOrd co : lst) {
            int i = co.i;
            int j = co.j;
            if(!vis[i][j]) {
                dfs(i, j, vis, grid);
            }
        }
        return noOfOnes;
    }

    void dfs(int i, int j, boolean[][] vis ,int [][] grid){

        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        vis[i][j] = true;
        // System.out.println(i+" "+j);
        noOfOnes--;
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {

                dfs(nrow, ncol, vis, grid);
            }
        }
    }
}


class CoOrd{
    int i , j;
    CoOrd(int x , int  y){
        i = x;
        j = y;
    }
}

