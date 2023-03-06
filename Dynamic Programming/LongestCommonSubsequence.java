import java.util.Arrays;

//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence {
    //memoization
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length() , m = s2.length();
        int dp[][] = new int[n][m];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(n-1,m-1,s1,s2,dp);
    }

    private int find(int i, int j, String s1, String s2, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int count = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            count = 1 + find(i-1,j-1,s1,s2,dp);
        }
        else count = Math.max(find(i-1,j,s1,s2,dp),find(i,j-1,s1,s2,dp));

        return dp[i][j] = count;
    }

    //tabulation
    public int tabulationLongestCommonSubsequence(String s1, String s2) {
        int n = s1.length() , m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
