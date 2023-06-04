//https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
import java.util.*;
public class MaximumValueOfKCoinsFromPiles {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size() + 1][k + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= piles.size(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= piles.size(); i++) {
            for (int j = 1; j <= k; j++) {
                int cur = 0;
                for (int x = 0; x < Math.min(piles.get(i - 1).size(), j); x++) {
                    cur += piles.get(i - 1).get(x);
                    dp[i][j] = Math.max(dp[i][j], cur + dp[i - 1][j - x - 1]);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }
        return dp[piles.size()][k];
    }
}
