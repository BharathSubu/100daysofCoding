//https://leetcode.com/problems/ugly-number-ii/
import java.util.*;
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long num = 1;
        pq.add(num);
        HashSet<Long> set = new HashSet<>();
        while (n!=0){
            num = pq.remove();
            if(!set.contains(num*2))
            {
                pq.add(num*2);
                set.add(num*2);
            }
            if(!set.contains(num*3))
            {
                pq.add(num*3);
                set.add(num*3);
            }
            if(!set.contains(num*5))
            {
                pq.add(num*5);
                set.add(num*5);
            }
            n--;
        }
        return (int)num;
     }
}
