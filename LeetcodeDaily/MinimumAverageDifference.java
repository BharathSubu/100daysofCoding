//https://leetcode.com/problems/minimum-average-difference/

import java.util.*;

public class MinimumAverageDifference {
    public int minimumAverageDifference(long[] nums) {
        int n = nums.length;
        long presum[] = new long[n];
        presum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            presum[i] = nums[i] + presum[i-1];
        }
        long res[] = new long[n];
        long total = presum[n-1];
        int min = 0;
        for (int i = 0; i < res.length; i++) {
            if(i!=n-1)
            res[i] = Math.abs(presum[i]/(i+1) - ((total - presum[i])/(n-(i+1))));
            else{
                res[i] = total/(i+1);
            }
            if(res[min]>res[i]) min = i;
        }
        return min;
    }
}