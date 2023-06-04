//https://leetcode.com/problems/shortest-bridge/
import java.util.*;
public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        int r = grid.length , c = grid[0].length;
        int vis[][] = new int[r][c];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
        Queue<Pair> qu = new LinkedList<>();
        outer:
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(vis[i][j] == Integer.MAX_VALUE && grid[i][j] == 1) {
                    dfs(i,j,r,c,grid,vis,qu);
                    break outer;
                }
            }
        }
        // System.out.println(qu);
        int dis = Integer.MAX_VALUE;
        int drow[] = {-1, 0, +1, 0, -1, -1, +1, +1};
        int dcol[] = {0, 1, 0, -1 , +1, -1, +1, -1};
        while (!qu.isEmpty()){
            Pair p = qu.remove();
            // System.out.println(p.j+" "+p.j+" "+p.step);
            for (int k = 0; k < 4; k++) {
                int nrow = p.i + drow[k];
                int ncol = p.j + dcol[k];
                if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == 0 && vis[nrow][ncol] > p.step + 1) {
                    vis[nrow][ncol] = p.step + 1;
                    qu.add(new Pair(nrow,ncol,p.step+1));
                }
                else if(nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == 1 && vis[nrow][ncol] == Integer.MAX_VALUE){
                    dis = Math.min(p.step,dis);
                }
            }
        }
        if(dis == Integer.MAX_VALUE) return 1;
        return dis;
    }

    private void dfs(int i, int j, int r, int c, int[][] grid, int[][] vis, Queue<Pair> lst) {
        // System.out.println(i+" "+j);
        vis[i][j] = 0;
        lst.add(new Pair(i,j,0));
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1 };
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == 1 && vis[nrow][ncol] == Integer.MAX_VALUE) {
                dfs(nrow,ncol,r,c,grid,vis,lst);
            }
        }
    }

    class Pair{
        int i,j,step;
        Pair(int i, int j,int step){
            this.i = i;
            this.j = j;
            this.step= step;
        }
    }
}
