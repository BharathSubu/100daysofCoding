//https://leetcode.com/problems/number-of-zero-filled-subarrays/
import java.util.*;
public class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        int i = 0;
        int n = nums.length;
        long count = 0;
        long ans = 0;
        while(i < n){
            if(nums[i] == 0) count++;
            else{
                ans+=(count*(count+1))/2;
                count = 0;
            }
            i++;
        }
        ans+=(count*(count+1))/2;
        return ans;
    }
}
