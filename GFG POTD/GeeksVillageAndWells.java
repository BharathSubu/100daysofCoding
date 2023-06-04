//https://practice.geeksforgeeks.org/problems/5a1277ffc1ec1d3a63d1a5d6b3920dd3d1294261/1
import java.util.*;
public class GeeksVillageAndWells {
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        int dist[][] = new int[n][m];
        Arrays.stream(dist).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
        Queue<Pair> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c[i][j] == 'W') {
                    qu.add(new Pair(i, j, 0));
                    dist[i][j] = 0;
                }
            }
        }

        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        while(!qu.isEmpty()){
            Pair parent = qu.remove();
            for (int k = 0; k < 4; k++) {
                int nrow = parent.i + drow[k];
                int ncol = parent.j + dcol[k];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && c[nrow][ncol] != 'N') {
                    if(dist[nrow][ncol] > parent.step + 1){
                        dist[nrow][ncol] = parent.step + 1;
                        qu.add(new Pair(nrow,ncol, parent.step+1));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(c[i][j] == 'H')
                {
                    if(dist[i][j] != Integer.MAX_VALUE) dist[i][j]*=2;
                    else dist[i][j] = -1;
                }
                else {
                    dist[i][j] = 0;
                }
            }
        }
        return dist;
    }
    class Pair{
        int i,j;
        int step;
        Pair(int _i, int _j , int _step){
            i = _i; j = _j; step=_step;
        }
    }
}
