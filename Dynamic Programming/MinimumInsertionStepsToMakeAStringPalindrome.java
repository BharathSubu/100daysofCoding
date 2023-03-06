//https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/
import java.util.*;
public class MinimumInsertionStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
    public int longestPalindromeSubseq(String s) {
        int  n = s.length();
        int dp[][] = new int[n][n];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(0,n-1,s,dp);
    }

    private int find(int i, int j, String s, int[][] dp) {
        if(i == j) return 1;
        if(i > j) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        int len = 0;
        if(s.charAt(i) == s.charAt(j)){
            len = 2 + find(i+1,j-1,s,dp);
        }
        else{
            len = Math.max(find(i+1,j,s,dp) ,find(i,j-1,s,dp));
        }
        return dp[i][j] = len;
    }
}
