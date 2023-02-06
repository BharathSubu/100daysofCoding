//https://leetcode.com/problems/shuffle-the-array/description/
import java.util.*;
public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int [] ans = new int[nums.length];
        int k = 0;
        for (int i = 0; i < n && k < nums.length; i++) {
            ans[k] = nums[i];
            k++;
            if(k<nums.length)
            {
                ans[k] = nums[i+n];
                k++;
            }
        }
        return ans;
    }
}
