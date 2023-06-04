//https://practice.geeksforgeeks.org/problems/09b910559335521654aa2909f86f893447d8f5ba/1
import java.util.*;
public class AnotherCoinChangeProblem {
    public static boolean makeChanges(int n, int k, int target, int[] coins) {
        int dp[][][] = new int[n][k+1][target+1];
        Arrays.stream(dp).forEach(a->Arrays.stream(a).forEach(b->Arrays.fill(b,-1)));
        return 1 == find(0,k,target,coins,dp);
    }

    static int find(int i , int k , int target , int coins[] , int dp[][][]){
        if(k == 0 && target == 0) return 1;
        if(i == coins.length || (k == 0 && target != 0)) return 0;
        if(dp[i][k][target] != -1) return dp[i][k][target];
        int noTake = find(i+1,k,target,coins,dp);
        if(noTake != 0) return dp[i][k][target] = noTake;
        int take = 0;
        if(target - coins[i] >= 0) take = find(i,k-1,target-coins[i],coins,dp);
        return dp[i][k][target] = take ;
    }
}
