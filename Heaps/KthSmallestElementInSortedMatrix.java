//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

import java.util.*;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int[] arr: matrix) {
            for (int num : arr) {
                pq.add(num);
            }
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }
        return res;
    }
}
