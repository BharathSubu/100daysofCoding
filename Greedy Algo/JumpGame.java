// https://leetcode.com/problems/jump-game/
class JumpGame {
    public boolean canJump(int[] nums) {
        int stepAvailable = 0;
        for(int i =0 ; i<nums.length ; i++)
        {
            if(nums[i] > stepAvailable){
               stepAvailable = nums[i];   
            }
            if(stepAvailable == 0 && i!=nums.length-1) return false;
            stepAvailable--;
        }
        return true;
    }
}