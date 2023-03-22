//https://leetcode.com/problems/largest-divisible-subset/

import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
         int [] dp = new int[n];
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0 ;i< n;i++){
            dp[i] = 1;
            map.put(i,i);
        }
        Arrays.fill(dp,1);
        int ans = 1;
        int maxidx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0){
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
