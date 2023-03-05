//https://leetcode.com/problems/distinct-subsequences/
import java.util.*;
public class DistinctSubsequences {
    public int numDistinct(String s1, String s2) {
        int n = s1.length() , m = s2.length();
        int dp[][] = new int[n][m];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(n-1,m-1,dp,s1,s2);
    }

    private int find(int i, int j, int[][] dp, String s1, String s2) {
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int case1 = 0;
        int case2 = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            case1 = find(i-1,j-1,dp,s1,s2);
        }
        case2 = find(i-1,j,dp,s1,s2);
        return dp[i][j] = case1+case2;
    }
}
