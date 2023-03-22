//https://leetcode.com/problems/number-of-longest-increasing-subsequence/
import java.util.*;
public class NumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        HashMap<Integer,Integer> map = new HashMap<>();
        findMAX(0,-1,n,nums,dp,map);
        return map.get(encode(0,0,n));
    }

    private int findMAX(int i, int prev,int n, int[] nums, int[][] dp, HashMap<Integer, Integer> map) {
        int e = encode(i, prev + 1, n);
        if(i == n) {
            map.put(e,1);
            return 0;
        }
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int e1 = encode(i+1,prev+1,n);
        int e2 = encode(i+1,i+1,n);
        int noTake = findMAX(i+1,prev,n,nums,dp,map);
        int take = 0;
        if(prev == -1 || nums[prev] < nums[i]){
            take = 1+  findMAX(i+1,i,n,nums,dp,map);
        }
        int w1 = map.get(e1);
        int w2 = map.get(e2);
        if(take == noTake ){
            if(take  == 0) map.put(e,1);
            else
                map.put(e,w1+w2);
        }
        else {
            if (take > noTake)
                map.put(e, w2);
            else  map.put(e ,w1);
        }
        return dp[i][prev+1] = Math.max(take,noTake);
    }

    //tabulation
    public int tabulationFindNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <= n ; i++) {
            int e = encode(n, i , n);
            map.put(e,1);
            dp[n][i] = 0;
        }
        for (int i = n-1; i >=0; i--) {
            for (int j = i-1; j >=-1 ; j--) {
                int notake = dp[i+1][j+1];
                int take = 0;
                if(j == -1 || nums[j] < nums[i]) take = 1 + dp[i+1][i+1];
                dp[i][j+1] = Math.max(take,notake);
                int e = encode(i, j + 1, n);
                int e1 = encode(i+1,j+1,n);
                int e2 = encode(i+1,i+1,n);
                int w1 = map.get(e1);
                int w2 = map.get(e2);
                if(take == notake ){
                    if(take  == 0) map.put(e,1);
                    else
                        map.put(e,w1+w2);
                }
                else {
                    if (take > notake)
                        map.put(e, w2);
                    else  map.put(e ,w1);
                }
            }
        }
        return  map.get(encode(0,0,n));
    }

    int encode(int i , int j , int n ){
        return i*(n+1) + j;
    }

    public static void main(String[] args) {
        NumberOfLIS sol = new NumberOfLIS();
        int[] nums = {1,2,4,3,5,4,7,2};
        System.out.print(sol.findNumberOfLIS(nums));
    }
}
