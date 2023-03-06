//https://leetcode.com/problems/wildcard-matching/
import java.util.*;
public class WildcardMatching {
    public boolean isMatch(String s1, String s2) {
        int n = s1.length() , m = s2.length();
        int dp[][] = new int[n+1][m+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        int ans = find(n,m,s1,s2,dp) ;
        return ans != 0 ? true : false ;
    }

    private int find(int i, int j, String s1, String s2, int[][] dp) {
        if(i == 0 && j == 0) return 1;
        if(i == 0 ) {
            for (int k = j; k >= 1; k--) {
                if(s2.charAt(k-1) != '*') return 0;
            }
            return 1;
        }
        if(j == 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = 0;
        if(s1.charAt(i-1) == s2.charAt(j-1) || s2.charAt(j-1) == '?'){
          return dp[i][j] = find(i-1,j-1,s1,s2,dp);
        }
        else if(s2.charAt(j-1) == '*'){
            boolean isOne = false;
            for (int k = i; k >= 0; k--) {
                int ans = find(k,j-1,s1,s2,dp);
                if(ans == 1){
                    isOne = true;
                    break;
                }
            }
            if(isOne) return dp[i][j] = 1;
            else return dp[i][j] = 0;
        }
        else return dp[i][j];
    }

    public static void main(String[] args) {
        WildcardMatching sol = new WildcardMatching();
        String s ="adceb" ,
        p = "*a*b";
        System.out.println(sol.isMatch(s,p));
    }
}
