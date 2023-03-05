//https://leetcode.com/problems/minimize-deviation-in-array/
import java.util.*;
public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==1) nums[i]*=2;
            pq.add(nums[i]);
            min = Math.min(min,nums[i]);
        }
        int res = Integer.MAX_VALUE;
        while(pq.peek()%2!=1){
            int max = pq.remove();
            res = Math.min(res,Math.abs(max - min));
            min = Math.min(max/2,min);
            pq.add(max/2);
        }
        return res;
    }
}
