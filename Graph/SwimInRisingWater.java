//https://leetcode.com/problems/swim-in-rising-water/submissions/893118107/
import java.util.*;

public class SwimInRisingWater {

    class Pair{
        int i,j,cost,costUntillNow;
        Pair(int _i,int _j,int _costUntillNow){
            i = _i;
            j = _j;
            costUntillNow = _costUntillNow;
        }
    }

    public int swimInWater(int[][] grid) {
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.costUntillNow-b.costUntillNow);
            pq.add(new Pair(0,0,grid[0][0]));

            int r = grid.length;
            int c = grid[0].length;

            int dist[][] = new int[r][c];
            Arrays.stream(dist).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
            dist[0][0] = 0;

            while (!pq.isEmpty()){
                Pair p = pq.remove();
                int i = p.i , j = p.j , uC = p.costUntillNow;
                int drow[] = {-1, 0, +1, 0};
                int dcol[] = {0, 1, 0, -1};
                if(i==r-1 && j == c-1) return uC;
                for (int k = 0; k < 4; k++) {
                    int nrow = i + drow[k];
                    int ncol = j + dcol[k];
                    if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c ) {
                        if(uC > grid[nrow][ncol] && dist[nrow][ncol] > uC){
                            dist[nrow][ncol] = uC;
                            pq.add(new Pair(nrow,ncol,uC));
                        }
                        else if(uC < grid[nrow][ncol] && dist[nrow][ncol] > (uC + Math.abs(grid[i][j] - grid[nrow][ncol]))){
                            dist[nrow][ncol] = grid[nrow][ncol];
                            pq.add(new Pair(nrow,ncol, dist[nrow][ncol]));
                        }
                    }
                }
            }
            return -1;
    }
}
