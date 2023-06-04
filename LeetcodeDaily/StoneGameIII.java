//https://leetcode.com/problems/stone-game-iii/
import java.util.*;
public class StoneGameIII {
    public String stoneGameIII(int[] piles) {
        Pair dp[][] = new Pair[piles.length][2];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,null));
        Pair res = find(0,0,dp,piles);
        int alice = res.alice;
        int bob = res.bob;
        if(bob == alice) return "Tie";
        return alice > bob ? "Alice" : "Bob";
    }

    private Pair find(int i, int isBob, Pair[][] dp, int[] piles) {
        if(i == piles.length) return new Pair(0,0);
        if(dp[i][isBob] != null) return dp[i][isBob];
        Pair res = new Pair(Integer.MIN_VALUE,Integer.MIN_VALUE);
        int total = 0;
        for (int j = i; j < i+3 && j < piles.length ; j++) {
            total+=piles[j];
            if(isBob == 0){
                Pair curr = find(j+1,1,dp,piles);
                if(res.alice < curr.alice + total){
                    res.alice = total + curr.alice;
                    res.bob = curr.bob;
                }
            }
            else{
                Pair curr = find(j+1,0,dp,piles);
                if(res.bob < curr.bob + total){
                    res.bob = curr.bob + total;
                    res.alice = curr.alice;
                }
            }
        }
        return dp[i][isBob] = res;
    }

    class Pair{
        int alice;
        int bob;
        Pair(int i, int j){
            alice = i;
            bob = j;
        }
    }
}
