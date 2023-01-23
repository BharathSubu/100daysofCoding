//https://leetcode.com/problems/shortest-path-in-binary-matrix/
//https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-a-binary-maze
import java.util.*;

public class ShortestPathInBinaryMatrix {

        class CoOrd {
            int i , j, cost;
            CoOrd(int _i , int _j , int _cost){
                i = _i;
                j = _j;
                cost = _cost;
            }
        }

        public int shortestPathBinaryMatrix(int[][] grid) {

            int r = grid.length;
            int c = grid.length;
            if(grid[0][0] == 1 || grid[r-1][c-1] == 1 ) return -1;
            if(0 == r-1 && 0 == r-1) return 1;
            Queue<CoOrd> qu =new LinkedList<>();
            qu.add(new CoOrd(0,0,1));
            int[][] dist = new int[r][c];
            for(int i = 0;i<r;i++) {
                for(int j =0;j<c;j++) {
                    dist[i][j] = (int)(1e9);
                }
            }
            dist[0][0] = 0;

            while (!qu.isEmpty()){
                CoOrd parent = qu.remove();
                int i = parent.i;
                int j = parent.j;
                int cost = parent.cost;

                //making parent visited;
                grid[i][j] = 1;

                //traversal
                int drow[] = {-1, 0, +1, 0, -1, -1, +1, +1};
                int dcol[] = {0, 1, 0, -1 , +1, -1, +1, -1};
                for (int k = 0; k < 8; k++) {
                    int nrow = i + drow[k];
                    int ncol = j + dcol[k];
                    if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == 0 && cost + 1 < dist[nrow][ncol]) {
                        if(nrow == r-1 && ncol == c-1) {
                            return cost+1;
                        }
                        dist[nrow][ncol] = cost + 1;
                        qu.add(new CoOrd(nrow,ncol,cost+1));
                    }
                }
            }
            return -1;
        }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix sol=new ShortestPathInBinaryMatrix();
        int grid[][]  = {{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(sol.shortestPathBinaryMatrix(grid));
    }
}
