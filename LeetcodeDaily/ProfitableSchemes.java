//https://leetcode.com/problems/profitable-schemes/
import java.util.*;
public class ProfitableSchemes {
    int mod = (int)Math.pow(10,9) + 7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        long dp[][][] = new long[m+1][n+1][100*m];
        Arrays.stream(dp).forEach(a->Arrays.stream(a).forEach(b->Arrays.fill(b,-1)));
        return (int)findAns(0,n,0,group, profit,m,minProfit,dp);
    }

    private long findAns(int i, int menleft, int amount, int[] group, int[] profit, int m, int minProfit, long[][][] dp) {
        if(i == m){
            if(amount >= minProfit) return 1;
            return 0;
        }
        if(dp[i][menleft][amount] != -1) return dp[i][menleft][amount];
        long notake = findAns(i+1,menleft,amount,group,profit,m,minProfit,dp);
        long take = 0;
        if(group[i] <= menleft) take = findAns(i+1,menleft-group[i],amount+profit[i],group,profit,m,minProfit,dp);
        dp[i][menleft][amount] = notake + take;
        return  dp[i][menleft][amount] %mod;
    }

    public int tabulationProfitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1000000007;
        int m = group.length;
        long [][][] dp = new long[m+1][n+1][m*100+1];
        Arrays.stream(dp).forEach(a->Arrays.stream(a).forEach(b->Arrays.fill(b,-1)));
        for (int i = 0; i < n+1 ; i++) {
            for (int j = 0; j < m*100 + 1; j++) {
                if(j < minProfit)
                dp[m][i][j] = 0;
                else dp[m][i][j] = 1;
            }
        }
        for (int i = m-1; i >= 0; i--) {
            int g = group[i] , p = profit[i];
            for (int amount = minProfit; amount >=0; amount--) {
                for (int menleft = n - g; menleft >= 0; menleft--) {
                    
                }
            }
        }
    }


}
