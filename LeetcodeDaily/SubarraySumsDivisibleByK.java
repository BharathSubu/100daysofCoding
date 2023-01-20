//https://leetcode.com/problems/subarray-sums-divisible-by-k/
import java.util.*;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count =0 ;
        int sum = 0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem < 0)
                rem += k;
            if(map.containsKey(rem)) count+=map.get(rem);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}
