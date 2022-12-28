// https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/

import java.util.*;

class RemoveStones {
    public static int minStoneSum(int[] piles, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((first,second)->second - first);
       for (Integer integer : piles) {
         pq.add(integer);
       }
       while(k!=0){
          int ans = pq.poll();
          pq.add(ans - ans/2);
          k--;
       }
       int res =0;
       while(!pq.isEmpty()) res+=pq.poll();
       return res;
    }
    public static void main(String[] args) {
        System.out.println(minStoneSum(null, 0));
    }
}