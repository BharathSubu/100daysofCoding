//https://leetcode.com/problems/01-matrix/

import java.util.*;

public class Matrix01 {

    int r = -1;
    int c = -1;

    public int[][] updateMatrix(int[][] mat) {
        r = mat.length;
        c = mat[0].length;
        int[][] res = new int[r][c];
        Arrays.stream(res).forEach(a -> Arrays.fill(a, -1));
        Queue<StepPair> qu = new LinkedList<>();
        boolean[][] vis = new boolean[r][c];
        Arrays.stream(vis).forEach(a -> Arrays.fill(a, false));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
               if(mat[i][j] == 0){
                   vis[i][j] = true;
                   qu.add(new StepPair(i,j,0));
                   res[i][j] = 0;
               }
            }
        }
        while (!qu.isEmpty()){
            StepPair p = qu.remove();
            if (p.j + 1 < c  && !vis[p.i][p.j+1] ) {
                vis[p.i][p.j+1] = true;
                res[p.i][p.j+1] = p.step + 1;
                qu.add(new StepPair(p.i, p.j + 1, p.step + 1));
            }
            if (p.j - 1 >= 0 && !vis[p.i][p.j-1]) {
                vis[p.i][p.j-1] = true;
                res[p.i][p.j-1] = p.step + 1;
                qu.add(new StepPair(p.i, p.j - 1, p.step + 1));
            }
            if (p.i + 1 < r  && !vis[p.i+1][p.j]) {
                vis[p.i+1][p.j] = true;
                res[p.i+1][p.j] = p.step + 1;
                qu.add(new StepPair(p.i + 1, p.j, p.step + 1));
            }
            if (p.i - 1 >= 0 && !vis[p.i-1][p.j]) {
                vis[p.i-1][p.j] = true;
                res[p.i-1][p.j] = p.step + 1;
                qu.add(new StepPair(p.i - 1, p.j, p.step + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
      int board[][] = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}, {0, 0, 0}};
      Matrix01 sol = new Matrix01();
      int res[][] = sol.updateMatrix(board);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }



}
class StepPair{
    int i , j;
    int step;
    StepPair(int a,int b,int s){
        i = a;
        j = b;
        step = s;
    }
}
