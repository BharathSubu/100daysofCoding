//https://www.youtube.com/watch?v=zKi4LzjK27k
import java.util.*;
public class New21Game {
    public double new21Game(int n, int k, int maxPts) {
        if (k==0 || k + maxPts <= n) return 1.0;
        double windowSum = 0;
        for (int i = k; i < k+maxPts; i++) {
            windowSum+= (i<=n) ? 1 : 0;
        }
        double dp[] = new double[n+1];
        Arrays.fill(dp,-1);
        for (int i = k-1; i > -1; i--) {
            dp[i] = windowSum / maxPts;
            double remove = 0;
            if(i + maxPts <= n)
                remove = (dp[i+maxPts] != -1) ? dp[i + maxPts] : 1;
            windowSum += dp[i] - remove;
        }
        return dp[0];

    }
}
