import java.util.Arrays;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return findMax(0,n-1,nums,dp);
    }

    private int findMax(int i, int j, int[] nums, int[][] dp) {
        if(i>j) return 0;
        int mini = Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for (int k = i; k <= j; k++) {
            int idx = nums[k];
            int prev = i-1 == -1 ? 1 : nums[i-1];
            int next = j+1 == nums.length ? 1 : nums[j+1];
            int cost = (idx * prev * next) + findMax(i,k-1,nums,dp) + findMax(k+1,j,nums,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
}
