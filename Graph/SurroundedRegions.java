//https://leetcode.com/problems/surrounded-regions/

import java.util.*;

public class SurroundedRegions {

    int r = -1 , c = -1;

    public void solve(char[][] board) {

         r =board.length;
         c = board[0].length;

        boolean[][] vis = new boolean[r][c];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));

        int row[] = { 0 , r-1 , -1 ,-1};
        int col[] = {-1, -1, 0 , c-1};

        for (int i = 0; i < 4 ; i++){
            if(row[i] != -1 ){
                for (int j = 0; j < c; j++) {
                    if(!vis[row[i]][j] && board[row[i]][j] == 'O'){
                        dfs(row[i],j,board,vis);
                    }
                }
            }
            else{
                for (int j = 0; j < r; j++) {
                    if(!vis[j][col[i]] && board[j][col[i]] == 'O'){
                        dfs(j,col[i],board,vis);
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(vis[i][j]) board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    void dfs(int i, int j , char[][] board, boolean vis[][]){
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && !vis[nrow][ncol] && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, board, vis);
            }
        }
    }
}
