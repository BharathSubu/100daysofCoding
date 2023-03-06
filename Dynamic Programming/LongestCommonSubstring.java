//https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-common-substring1452
import java.util.*;
public class LongestCommonSubstring {
    int longestCommonSubstr(String s1, String s2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        int ans = 0;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m ; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    int val = 1 + dp[i-1][j-1];
                    dp[i][j] = val;
                    ans = Math.max(ans,val);
                }
                else
                    dp[i][j] = 0;
            }
        }
        return ans;
    }


}
