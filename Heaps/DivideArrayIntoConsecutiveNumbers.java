// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/submissions/861197432/

import java.util.*;

class DivideArrayIntoConsecutiveNumbers {
    public boolean isPossibleDivide(int[] hand, int groupSize) {
                if (hand.length % groupSize != 0)
            return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
        }
        // System.out.println(map);

        int prev = pq.peek();
        map.put(prev, map.get(prev) - 1);
        if (map.get(prev) == 0) {
            map.remove(prev);
            pq.poll();
        }
        int count = 1;
        while (!map.isEmpty()) {
            while (count < groupSize && map.containsKey(prev + 1)) {
                prev++;
                count++;
                map.put(prev, map.get(prev) - 1);
                if (map.get(prev) == 0) {
                    map.remove(prev);
                    // System.out.println(prev +" "+pq.peek());
                    if(pq.peek() != prev) return false;
                    else{
                        pq.poll();
                    }
                }
            }
            
            if (count != groupSize)
                return false;
            if(map.isEmpty()) return true;
            prev = pq.peek();
            count = 1;
            map.put(prev, map.get(prev) - 1);
            if (map.get(prev) == 0) {
                map.remove(prev);
                pq.poll();
            }
        }
        return true;
    }
}