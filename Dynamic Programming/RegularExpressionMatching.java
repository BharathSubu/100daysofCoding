//https://leetcode.com/problems/regular-expression-matching/
import java.util.*;
public class RegularExpressionMatching {
    public boolean isMatch(String s1, String s2) {
        int n = s1.length() , m = s2.length();
        int dp[][] = new int[21][21];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        int ans = find(0,0,s1,s2,dp) ;
        return ans != 0 ? true : false ;
    }
    private int find(int i, int j, String s1, String s2, int[][] dp) {
        if(i >= s1.length() && j >= s2.length()) return 1;
        if(i >= s1.length() || j >= s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = 0;
        boolean match = i < s1.length() &&  (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.');

        if( j+1 < s2.length() && s2.charAt(j+1) == '*'){
            int ans = find(i,j+2,s1,s2,dp);
            if(ans == 1) return dp[i][j] = 1;
            if(match){
                ans = find(i+1,j,s1,s2,dp);
            }
            if(ans == 1) return dp[i][j] = 1;
        }

        if(match) return dp[i][j] = find(i+1,j+1,s1,s2,dp);

        return dp[i][j];
   }

    public static void main(String[] args) {
        String s = "aaaaaaaa", p = "c*a*a";
        RegularExpressionMatching sol = new RegularExpressionMatching();
        System.out.println(sol.isMatch(s,p));
    }
}
