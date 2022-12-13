//https://leetcode.com/problems/minimum-size-subarray-sum/description/

class MinimumSizeSubarraySum{
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length + 1;
        int start = 0;
        int currsum = 0;
        for (int i = 0; i < nums.length; i++) {
            currsum+=nums[i];
            while(currsum >= target){
                len = Math.min(len, i-start+1);
                currsum-=nums[start];
                start++;
            }
        }
        if(len == nums.length+1) return 0;
        return len;

    }
    public static void main(String[] args) {
        int target = 8 ; int [] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(target, nums));
    }
}