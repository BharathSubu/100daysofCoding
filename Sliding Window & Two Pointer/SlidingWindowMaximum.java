// https://leetcode.com/problems/sliding-window-maximum/description/

import java.util.*;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int [] res = new int[nums.length - k + 1];
        int len =0;
        for (int i = 0; i < nums.length; i++) {
            // System.out.println(dq);
            if(dq.size() == 0 || nums[dq.peekLast()] > nums[i]){
                dq.addLast(i);
            }
            else if( nums[dq.peekLast()] <= nums[i]){
                while( !dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                    dq.removeLast();
                }
                dq.addLast(i);
            }
            while(!dq.isEmpty() && dq.peekFirst() <= (i - k)){
                dq.removeFirst();
            }
            if(i >= (k-1)){
                res[len] = nums[dq.peekFirst()];
                len++;
            }
        }
        return res;  
    }
}