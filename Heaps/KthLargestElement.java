//https://leetcode.com/problems/kth-largest-element-in-an-array/
import java.util.*;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> ((first, second) -> second - first);
        int res = 0;
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }
        return res;
    }
}
