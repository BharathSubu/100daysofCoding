import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1
public class NumberOfDistinctIslands {

    int r = -1;
    int c = -1;
    String s = "";
    HashSet<String> res = new HashSet<>();

    int countDistinctIslands(int[][] grid) {

        res = new HashSet<>();

        r= grid.length;
        c = grid[0].length;

        boolean [][] vis = new boolean[r][c];

        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!vis[i][j] && grid[i][j] == 1){
                    s = "S";
                    dfs(0 , i , j , vis,grid);
                    res.add(s);
                }
            }
        }
        return res.size();
    }

    private void dfs(int step, int i, int j,boolean[][] vis, int[][] grid) {
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        char dir[] = {'D','R','U','L'};
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                s+=dir[k];
                s+=Integer.toString(step);
                dfs(step+1, nrow, ncol,vis,grid);
            }
        }
        if(step==0){
            System.out.println(s);
            res.add(s);
        }
    }

    public static void main(String[] args) {
        int grid[][] = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        NumberOfDistinctIslands sol = new NumberOfDistinctIslands();
        System.out.println(sol.countDistinctIslands(grid));
    }
}
