// https://leetcode.com/problems/binary-subarrays-with-sum/
import java.util.*;

class BinarySubarraysWithSum{
    public int numSubarraysWithSum(int[] nums, int k) {
        HashMap<Integer,Integer> visited = new HashMap<>();
        int presum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            if (presum == k)
                count++;
            int h = presum - k;
            if (visited.containsKey(h))
            {
                count += visited.get(h);
            }
            if(!visited.containsKey(presum))
            visited.put(presum, 1);
            else{
                visited.put(presum, visited.get(presum)+1);
            }
        }
        return count;
    }
}