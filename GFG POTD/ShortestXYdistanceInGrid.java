//https://practice.geeksforgeeks.org/problems/7366ce450d84b55391fc787a681c4d60de359e72/1
import java.util.*;
public class ShortestXYdistanceInGrid {
    static class Pair
    {
        int x , y , step;
        Pair(int i , int j , int s){
            x = i; y=j; step=s;
        }

    }
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int n, int m) {
        Queue<Pair> qu = new LinkedList<>();
        int dist[][] = new int[n][m];
        Arrays.stream(dist).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid.get(i).get(j) == 'X'){
                    qu.add(new Pair(i,j,0));
                    dist[i][j] = 0;
                }
            }
        }
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        int ans = Integer.MAX_VALUE;
        while(!qu.isEmpty()){
            Pair p = qu.remove();
            for (int k = 0; k < 4; k++) {
                int nrow = p.x + drow[k];
                int ncol = p.y + dcol[k];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && (dist[nrow][ncol] > p.step + 1)) {
                    dist[nrow][ncol] = p.step + 1;
                    if(grid.get(nrow).get(ncol) == 'Y') {
                        ans = Math.min(ans, dist[nrow][ncol] );
                    }else
                        qu.add(new Pair(nrow,ncol,dist[nrow][ncol]));
                }
            }
        }
        return ans;
    }


}
