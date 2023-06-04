//https://leetcode.com/submissions/detail/956875206/
import java.util.*;
public class MaximalSquare {
    int area = 0;
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length , c = matrix[0].length;
        int dp[][] = new int[r][c];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        find(0,0,r,c,dp,matrix);
        return area;
    }
    int find(int i,int j, int r , int c , int dp[][] , char[][] matrix){
        if(i == r || j == c) return 0;
        // System.out.println(i+" "+j);
        if(dp[i][j] != -1) return dp[i][j];
        int next = Math.min(find(i,j+1,r,c,dp,matrix), Math.min(find(i+1,j,r,c,dp,matrix), find(i+1,j+1,r,c,dp,matrix)));
        dp[i][j] = 0;
        if(matrix[i][j] == '1') {
            dp[i][j] = 1 + next;
            // System.out.println(i+" "+j+" ->"+dp[i][j]);
            area = Math.max(area,(int)Math.pow(dp[i][j],2));
        }
        return dp[i][j];
    }
}
