//https://practice.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=printing-longest-increasing-subsequence
import java.util.*;
public class PrintingLIS {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]){
        int [] dp = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0 ;i< n;i++){
            dp[i] = 1;
            map.put(i,i);
        }
        Arrays.fill(dp,1);
        int ans = 1;
        int maxidx = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    if(dp[i] < 1+dp[j]){
                        dp[i] = 1+dp[j];
                        map.put(i,j);
                    }
                }
            }
            if(ans<dp[i]){
                ans = Math.max(ans,dp[i]);
                maxidx = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[maxidx]);
        while (map.get(maxidx) != maxidx){
            maxidx = map.get(maxidx);
            res.add(nums[maxidx]);
        }
        Collections.reverse(res);
        return res;
    }

}
