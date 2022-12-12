// https://leetcode.com/problems/max-consecutive-ones-iii/

import java.util.*;

class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int count0 = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) count0++;
            while(count0 > k){
              if(nums[start]==0) count0--;
              max = Math.max(max, i - start);
              start++;
            }
        }
        max = Math.max(max, nums.length - start);
        return max;
    }
}