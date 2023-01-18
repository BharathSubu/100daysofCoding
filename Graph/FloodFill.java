//https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flood-fill-algorithm

import java.sql.SQLOutput;
import java.util.*;

public class FloodFill {

    int r = -1;
    int c = -1;
    int cl = -1;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
         r = image.length;
         c = image[0].length;
        int[][] res = new int[r][c];

        boolean[][] vis = new boolean[r][c];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));

        cl = image[sr][sc];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(image[i][j]!=cl) vis[i][j] = true;
                res[i][j]= image[i][j];
            }
        }

        dfs(sr,sc,res,image,newColor,vis);
//        for (int [] a: res ) {
//            System.out.println(Arrays.toString(a));
//        }
        return res;
    }

    void dfs(int i, int j , int[][] res , int[][] image , int newColor , boolean vis[][]){
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        vis[i][j] = true;
        res[i][j] = newColor;
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && !vis[nrow][ncol] && image[nrow][ncol] == cl) {
                dfs(nrow, ncol, res,image,newColor,vis);
            }
        }
    }

    public static void main(String[] args) {
        FloodFill sol = new FloodFill();
        int [][]image = {{1,1,1},{1,1,0},{1,0,1}} ;
        int sr = 1, sc = 1, color = 2 ;
        System.out.println(sol.floodFill(image,sr,sc,color));
    }

}
