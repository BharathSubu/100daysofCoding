//https://practice.geeksforgeeks.org/problems/2145720aebf8ea0b07f76b17217b3353a0fbea7f/1
import java.util.*;
public class FillTheMatrix {
    static class Pair{
        int i , j ,step;
        Pair(int x , int y , int cost){
            i = x;
            j = y;
            step = cost;
        }
    }
    public static int minIteration(int n, int m, int x, int y){
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(x-1,y-1,0));
        int max = 0;
        boolean [][] vis = new boolean[n][m];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));
        vis[x-1][y-1] = true;
        while (!qu.isEmpty()){
            Pair p = qu.remove();
            int i = p.i , j = p.j;
            max = Math.max(max,p.step);
            int drow[] = {-1, 0, +1, 0};
            int dcol[] = {0, 1, 0, -1};
            for (int k = 0; k < 4; k++) {
                int nrow = i + drow[k];
                int ncol = j + dcol[k];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    qu.add(new Pair(nrow,ncol,p.step + 1));
                    vis[nrow][ncol] = true;
                }
            }
        }
        return max;
    }
}
