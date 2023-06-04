//https://leetcode.com/problems/stone-game-ii/
import java.util.*;
public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int dp[][][] = new int[piles.length+1][piles.length+1][2];
        Arrays.stream(dp).forEach(a->Arrays.stream(a).forEach(b->Arrays.fill(b,-1)));
        return dfs(0,1,0,dp,piles);
    }

    int dfs(int i, int m, int isBob, int[][][] dp, int[] piles){
        if(i == piles.length) return 0;
        if(dp[i][m][isBob] != -1) return dp[i][m][isBob];
        int sum = isBob == 0 ? 0 : Integer.MAX_VALUE;
        int total = 0;
        for (int j = 1; j <= 2*m && (i + j <= piles.length); j++) {
            total+= piles[i+j-1];
            if(isBob == 0){
                sum = Math.max(sum,total + dfs(i+j,Math.max(m,j),1,dp,piles));
            }
            else{
                sum = Math.min(sum,dfs(i+j,Math.max(m,j),0,dp,piles));
            }
        }
        return dp[i][m][isBob] = sum;
    }
}
