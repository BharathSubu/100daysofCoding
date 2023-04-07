//https://leetcode.com/contest/weekly-contest-339/
import java.util.*;
public class Solution {
     
        public int findTheLongestBalancedSubstring(String s) {
            int i = 0;
            int len = 0;
            Stack<Character> st = new Stack<>();
            while (i < s.length()){
                if(s.charAt(i) == '0'){
                    st.push('0');
                }
                else{
                    int currlen = 0;
                    while (!st.isEmpty() && i < s.length() && s.charAt(i) == '1'){
                        currlen+=2;
                        st.pop();
                        i++;
                    }
                    st = new Stack<>();
                    if(i < s.length() && s.charAt(i) == '0') st.push('0');
                    len = Math.max(len,currlen);
                }
                i++;

            }
            return len;
        }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(0,new ArrayList<>());
        res.get(0).add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int currList = 0;
            boolean isAdded = false;
            while(currList != res.size()){
                if(!res.get(currList).contains(nums[i])){
                    res.get(currList).add(nums[i]);
                    isAdded = true;
                }
                currList++;
            }
            if(!isAdded) {
                res.add(new ArrayList<>());
                res.get(res.size() - 1).add(nums[i]);
            }
        }
        return res;
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward2.length;
        int dp[][] = new int[n+1][k+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        for (int i = 1; i <= k; i++) {
            dp[n][i] = Integer.MIN_VALUE/2;
        }
        dp[n][0] = 0;
        for(int i = n-1 ; i >= 0 ; i--){
            for (int j = 0; j <= k; j++) {
                int noTake = reward2[i] + dp[i+1][j];
                int take = Integer.MIN_VALUE;
                if(j > 0)
                    take = reward1[i] + dp[i+1][j-1];
                return dp[i][j] = Math.max(take,noTake);
            }
        }
        return dp[0][k];
    }

    private int findMax(int i, int k, int[] reward1, int[] reward2, int[][] dp) {
        if(i == reward1.length && k > 0) return Integer.MIN_VALUE/2;
        if(i == reward1.length) return 0;
        if(dp[i][k] != -1) return dp[i][k];
        int noTake = reward2[i]+ findMax(i+1,k,reward1,reward2,dp);
        int take = Integer.MIN_VALUE;
        if(k > 0)
            take = reward1[i] + findMax(i+1,k-1,reward1,reward2,dp);
        return dp[i][k] = Math.max(take,noTake);
    }

    class Pair{
            int first , second;
            Pair(int f , int s){
                first = f;
                second = s;
            }
    }
}
