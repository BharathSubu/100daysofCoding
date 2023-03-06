//https://leetcode.com/problems/delete-operation-for-two-strings/
import java.util.*;
public class DeleteOperationforTwoStrings {
    public int minDistance(String s1, String s2) {
       int n = s1.length() , m = s2.length();
       int k = longestCommonSubsequence(s1,s2);
       return (n-k)+(m-k);
    }

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
}
