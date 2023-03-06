//https://leetcode.com/problems/edit-distance/
import java.util.*;
public class EditDistance {
    public int minDistance(String s1, String s2) {
        int n = s1.length() , m = s2.length();
        int dp[][] = new int[n+1][m+1];
        if(n == 0) return m;
        if(m == 0) return n;
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(n,m,s1,s2,dp);
    }

    private int find(int i, int j, String s1, String s2, int[][] dp) {
        if(i == 0 || j == 0){
            return dp[i][j] = i == 0 ? j : i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            dp[i][j] = find(i-1,j-1,s1,s2,dp);
        }
        else{
            int replace = find(i-1,j-1,s1,s2,dp);
            int insert = find(i,j-1,s1,s2,dp);
            int delete = find(i-1,j,s1,s2,dp);
            dp[i][j] = 1 + Math.min(replace,Math.min(insert,delete));
        }
        return dp[i][j];
    }
}
