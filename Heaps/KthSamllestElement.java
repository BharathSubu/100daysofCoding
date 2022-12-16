//https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=kth-smallest-element
import java.util.*;
public class KthSamllestElement {

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : arr) {
                pq.add(num);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }
        return res;
    }
}
