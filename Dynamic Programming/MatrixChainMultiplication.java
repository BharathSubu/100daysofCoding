//https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=matrix-chain-multiplication
import java.util.*;
public class MatrixChainMultiplication {
    //memoization
    static int matrixMultiplication(int n, int arr[])
    {
        int dp[][] = new int[n][n];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return findAns(1,n-1,n,arr,dp);
    }

    private static int findAns(int i, int j, int n, int[] arr, int[][] dp) {
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int num = (arr[i-1] * arr[k] * arr[j]) + findAns(i,k,n,arr,dp) + findAns(k+1,j,n,arr,dp);
            mini = Math.min(mini,num);
        }
        return dp[i][j] = mini;
    }

    //tabulation
    static int tabulationMatrixMultiplication(int n, int arr[])
    {
        int dp[][] = new int[n][n];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for(int i=n-1; i>=1; i--){
            for(int j=i+1; j<n; j++){
                int mini = Integer.MAX_VALUE ;
                for(int k = i; k<= j-1; k++){
                    int ans = dp[i][k]+ dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    mini = Math.min(mini,ans);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n-1];
    }
}
