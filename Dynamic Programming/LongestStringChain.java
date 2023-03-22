//https://leetcode.com/problems/longest-string-chain/
import java.util.*;
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int n = words.length;
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(words[i],i);
        }
        int dp[][] = new int[n][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        int ans = 0;
        for (int i =0;i<n;i++)
            ans = Math.max(ans,findMax(i,-1,dp,map,words));
        return ++ans;
    }


    private int findMax(int i,int j,  int[][] dp, HashMap<String,Integer> map , String[] words) {

        if(dp[i][j+1] != -1) return dp[i][j+1];
        int remove = 0;
        String oldW = new String(words[i]);
        for (int k = 0; k < oldW.length(); k++) {
            String newW = new String(oldW.substring(0,k)+""+oldW.substring(k+1,oldW.length()));
            if(map.containsKey(newW)){
                remove = Math.max(remove,1+findMax(map.get(newW),i,dp,map,words));
            }
        }
        return dp[i][j+1] = remove;
    }

    public static void main(String[] args) {
        LongestStringChain sol = new LongestStringChain();
        String words []= {"xbc","xb","xbca"};
        System.out.println(sol.longestStrChain(words));
    }
}
