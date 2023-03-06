//https://practice.geeksforgeeks.org/problems/9dacc32ad062be6e2ba8f6c41aad0b2b2376397d/1
import java.util.*;
public class WallsColoringII {
    class  Pair{
        int idx ; int val;
        Pair(int i , int v){
            idx = i;
            val = v;
        }
    }
    int minCost(int [][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        if(k == 1 && n >=2 ) return -1;
        int dp[][] = new int[n][k];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
        Pair first  = new Pair(-1,Integer.MAX_VALUE) ;
        Pair second = new Pair(-1,Integer.MAX_VALUE) ;
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
            if (dp[0][i] <= first.val)
            {
                second = new Pair(first.idx,first.val);
                first.val = dp[0][i];
                first.idx = i;
            }
            else if (dp[0][i] < second.val && dp[0][i] != first.val)
            {
                second.val = dp[0][i];
                second.idx = i;
            }
        }
        for (int i = 1; i < n; i++) {
            Pair f = new Pair(first.idx, first.val);
            Pair s = new Pair(second.idx, second.val);
            first  = new Pair(-1,Integer.MAX_VALUE) ;
            second = new Pair(-1,Integer.MAX_VALUE) ;
            for (int j = 0; j < k; j++) {
                if(j!=f.idx)
                    dp[i][j] = Math.min(dp[i][j],costs[i][j] + f.val);
                else
                    dp[i][j] = Math.min(dp[i][j],costs[i][j] + s.val);
                if (dp[i][j] <= first.val)
                {
                    second = new Pair(first.idx,first.val);
                    first.val = dp[i][j];
                    first.idx = j;
                }
                else if (dp[i][j] < second.val && dp[i][j] != first.val)
                {
                    second.val = dp[i][j];
                    second.idx = j;
                }
            }
        }
        return Math.min(second.val,first.val);
    }
}
