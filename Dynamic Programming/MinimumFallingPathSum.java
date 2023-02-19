//https://leetcode.com/problems/minimum-falling-path-sum/
import java.util.*;
public class MinimumFallingPathSum {
    //tabulation
    public int tabulationMinFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for(int i = n-2; i >=0 ; i--){
            for (int j = 0; j < n; j++) {
                int min =  Integer.MAX_VALUE;
                int drow[] = {+1, 1, +1};
                int dcol[] = {-1, 0, +1};
                for (int k = 0; k < 3; k++) {
                    int nrow = i + drow[k];
                    int ncol = j + dcol[k];
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n ) {
                        min = Math.min(min,matrix[nrow][ncol]);
                    }
                }
                matrix[i][j] +=min;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(matrix[0][i],min);
        }
        return min;
    }
}
