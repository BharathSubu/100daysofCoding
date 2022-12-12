import javax.swing.GroupLayout.Group;

// https://leetcode.com/problems/rotting-oranges/

import java.util.*;

public class RottenOrange {
    public class Pair {
        int row, col, time;

        Pair(int r, int c, int t) {
            row = r;
            col = c;
            time = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> qu = new LinkedList<>();

        int visited[][] = new int[row][col];

        int countfresh = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    qu.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }
                else{
                    visited[i][j] = 0;
                }

                if (grid[i][j] == 1) countfresh++; 
            }
        }

        int tm = 0;
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1}; 
        int cnt = 0;

        while (!qu.isEmpty()) {
            int r = qu.peek().row;
            int c = qu.peek().col;
            int t = qu.peek().time;
            tm = Math.max(tm, t);
            qu.remove();
            for (int i = 0; i < 4; i++) {
              int nrow = r + drow[i];
              int ncol = c + dcol[i];
              if (nrow >= 0 && nrow < row && ncol >= 0 && ncol < col &&
                visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                qu.add(new Pair(nrow, ncol, t + 1));
                visited[nrow][ncol] = 2;
                cnt++;
              }
            }
        }
        if (cnt != countfresh) return -1;
        return tm;    
    }

    public static void main(String[] args) {

    }
}