
//https://practice.geeksforgeeks.org/problems/844b4fdcd988ac5461324d62d43f7892749a113c/1

import java.util.*;

public class DistinctColoring {
//    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
//       long [][] dp = new long[N][3];
//       for (long[]d:dp) Arrays.fill(d,Long.MAX_VALUE);
//       long ans = Long.MAX_VALUE;
//       for(int i = 0 ; i <3 ; i++){
//           dfs(0,i,r,g,b,dp);
//           ans = Math.min(ans,dp[0][i]);
//       }
//       return ans;
//    }
//
//    private static long dfs(int i, int j,int[]r, int[]g, int[]b, long[][] dp) {
//        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
//        if(i==(r.length-1)){
//            dp[i][j] = getVal(i,j,r,g,b);
//        }
//        else {
//            for (int k = 0; k < 3; k++) {
//                if (j != k) {
//                    dp[i][j] = Math.min(dp[i][j], getVal(i, j, r, g, b) + dfs(i + 1, k, r, g, b, dp));
//                }
//            }
//        }
//        return dp[i][j];
//    }
//
//    static int getVal(int n,int start, int[]r, int[]g, int[]b){
//        if(start==0) return r[n];
//        if(start==1) return g[n];
//        else return b[n];
//    }

    public static long distinctColoring(int n, int[]r, int[]g, int[]b){
        long [][] dp = new long[n][3];
        for (long[]d:dp) Arrays.fill(d,Long.MAX_VALUE);
        long ans = Long.MAX_VALUE;
        for(int i = n-1; i >=0 ; i++){
            if(i == n - 1){
                for(int j =0; i<3;j++){
                    dp[i][j] = getVal(i,j,r,g,b);
                }
            }
            else{
                for(int j =0; i<3;j++){
                    for(int k = 0;k < 3 ; k++){
                        if(j!=k)
                        dp[i][j] = Math.min(dp[i][j],getVal(i,j,r,g,b) + dp[i+1][k]);
                    }
                }
            }
        }
        for(int i = 0 ; i <3 ; i++){
            ans = Math.min(ans,dp[0][i]);
        }
        return ans;
    }
    static int getVal(int n,int start, int[]r, int[]g, int[]b){
        if(start==0) return r[n];
        if(start==1) return g[n];
        else return b[n];
    }

}
