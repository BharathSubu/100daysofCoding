//https://leetcode.com/problems/jump-game-ii/
import java.util.*;
public class JumpGameII {
    public int jump(int[] nums) {
        int curr = 0;
        int farthest = 0;
        int jumps = 0;
        for(int i =0 ; i<nums.length-1 ; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if(i == curr){
                curr = farthest;
                jumps++;
            }
        }
        return jumps;
    }
}
