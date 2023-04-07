//https://leetcode.com/problems/minimize-maximum-of-array/

public class MinimizeMaximumOfArray  {
    public int minimizeArrayValue(int[] nums) {
        int res = nums[0];
        long sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum+=nums[i];
            int curr = (int)intCeil(sum,(i+1));
            res = Math.max(res,curr);

        }
        return res;
    }
    public long intCeil(long a,int b) {
        if(a%b!=0) {
            return (a/b)+1;
        }
        else
            return a/b;
    }
}
