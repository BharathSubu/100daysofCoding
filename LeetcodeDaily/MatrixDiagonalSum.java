//https://leetcode.com/problems/matrix-diagonal-sum/

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int i = 0 , j = 0 , k = n-1;
        int sum = 0;
        for (int l = 0; l < n; l++) {
            sum+=mat[i][j];
            if(j!=k) sum+=mat[i][k];
            i++;
            j++;
            k--;
        }
        return sum;
    }
}
