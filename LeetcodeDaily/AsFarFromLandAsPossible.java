
//https://leetcode.com/problems/as-far-from-land-as-possible/

import java.util.*;

public class AsFarFromLandAsPossible {
    class Pair{
        int i,j,cost;
        Pair(int _i,int _j,int _cost){
            i = _i;
            j = _j;
            cost = _cost;
        }
    }

    public int maxDistance(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dist[][] = new int[r][c];
        Arrays.stream(dist).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 1) bfs(i,j,r,c,dist,grid);
            }
        }
        int max = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 0 &&  dist[i][j] != Integer.MAX_VALUE ) {
                    max = Math.max(max,dist[i][j]);
                }
            }
        }
        return max;
    }

    private void bfs(int i, int j, int r, int c, int[][] dist, int[][] grid) {
        dist[i][j] = 0;
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(i,j,0));
        while (!qu.isEmpty()){
            Pair p = qu.remove();
            int drow[] = {-1, 0, +1, 0};
            int dcol[] = {0, 1, 0, -1};
            for (int k = 0; k < 4; k++) {
                int nrow = p.i + drow[k];
                int ncol = p.j + dcol[k];
                if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == 0){
                    if(dist[nrow][ncol] > (p.cost + 1)){
                        dist[nrow][ncol] = p.cost + 1;
                        qu.add(new Pair(nrow,ncol,p.cost+1));
                    }
                }
            }
        }
    }
}
