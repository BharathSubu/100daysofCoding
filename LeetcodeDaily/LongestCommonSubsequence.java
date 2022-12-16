//https://leetcode.com/problems/longest-common-subsequence/submissions/860065049/

import java.util.*;

class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int id1 = text1.length()- 1, id2 = text2.length() - 1;
        int dp[][] = new int[text1.length()][text2.length()];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return findLCM(text1,text2,id1,id2,dp);
    }

    static int findLCM(String text1, String text2, int id1, int id2 , int[][] dp) {
        if(id1 < 0 || id2 < 0) return 0;
        if(dp[id1][id2] != -1) return dp[id1][id2];
        if(text1.charAt(id1)==(text2.charAt(id2))){
            dp[id1][id2] = 1 + findLCM(text1, text2, id1-1, id2-1, dp);
            return dp[id1][id2];
        }
        dp[id1][id2] = Math.max(findLCM(text1, text2, id1, id2-1, dp), findLCM(text1, text2, id1-1, id2, dp));
        return dp[id1][id2];
    }


    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace" ;
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}