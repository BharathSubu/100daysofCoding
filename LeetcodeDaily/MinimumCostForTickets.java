//https://leetcode.com/problems/minimum-cost-for-tickets/
import java.util.*;
public class MinimumCostForTickets {
    int add[] = {1,7,30};
    public int mincostTickets(int[] days, int[] costs) {
        int dn = days.length;
        int cn = costs.length;
        int dp[][] = new int[dn][days[dn-1]+30];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return find(0,0,days,costs,dp);
    }

    private int find(int i, int j , int[] days, int[] costs, int[][] dp) {
        if(i == days.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int price = Integer.MAX_VALUE;
        if(days[i] > j){
            for (int k = 0; k < costs.length ; k++) {
                price = Math.min(price,costs[k] + find(i+1,j+add[k],days,costs,dp));
            }
        }
        price = Math.min(price,find(i+1,j,days,costs,dp));
        return dp[i][j] = price;
    }

    public static void main(String[] args) {
        int days[] = {1,4,6,7,8,20};
        int cost[] = {2,7,15};
        MinimumCostForTickets sol = new MinimumCostForTickets();
        System.out.println(sol.mincostTickets(days,cost));
    }
}
