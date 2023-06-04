//https://leetcode.com/problems/smallest-number-in-infinite-set/
import java.util.*;

public class SmallestNumberInInfiniteSet {
    PriorityQueue<Integer> qu = new PriorityQueue<Integer>();
    public SmallestNumberInInfiniteSet() {
        qu = new PriorityQueue<Integer>();
        for(int i = 1; i<1001 ; i++) qu.add(i);
    }

    public int popSmallest() {
        int ans = -1;
        if(!qu.isEmpty()) ans = qu.remove();
        return ans;
    }

    public void addBack(int num) {
        if(!qu.contains(num)) qu.add(num);
    }
}
