//https://leetcode.com/problems/solving-questions-with-brainpower/
import java.util.*;
public class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n];
        Arrays.fill(dp,-1);
        return find(0,n,questions,dp);
    }

    private long find(int i, int n, int[][] questions, long[] dp) {
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        long notake = find(i+1,n,questions,dp);
        long take = questions[i][0] + find(i+questions[i][1]+1,n,questions,dp);
        return dp[i] = Math.max(notake,take);
    }
}
