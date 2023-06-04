//https://leetcode.com/problems/maximize-score-after-n-operations/
import java.util.*;
public class MaximizeScoreAfterNOperations {
    public int maxScore(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return dfs(0,1,nums,map);
    }

    private int dfs(int mask, int op,int [] nums, HashMap<Integer, Integer> map) {
        if(map.containsKey(mask)) return map.get(mask);
        int score = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(((1 << i & mask) != 0) || ((1 << j & mask) != 0)) continue;
                int newMask = mask | 1 << i | 1 << j;
                int currScore = op * gcd(nums[i],nums[j]);
                score = Math.max(score,currScore + dfs(newMask,op+1,nums,map));
            }
        }
        map.put(mask,score);
        return  score;
    }
     int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
