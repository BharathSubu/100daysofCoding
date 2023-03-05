//https://leetcode.com/problems/ipo/
import java.util.*;
public class IPO {
    class Pair{
        int p1 , p2;
        Pair(int i1 , int i2){
            p1 = i1;
            p2 = i2;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.p1 == b.p1) return b.p2-a.p2;
            return a.p1-b.p1;
        });
        PriorityQueue<Pair> resPq = new PriorityQueue<>((a,b)->b.p2-a.p2);
        for (int i = 0; i < profits.length; i++) {
            pq.add(new Pair(capital[i],profits[i]));
        }
        int cost = w;
        while (k!=0){
            while(!pq.isEmpty() && pq.peek().p1 <= cost){
                resPq.add(pq.remove());
            }
            if(!resPq.isEmpty()) {
                cost+=  resPq.remove().p2;
            }
            else break;
            k--;
        }
        return cost;
    }

    public static void main(String[] args) {
        IPO sol = new IPO();
        int profit[] = {1,2,3};
        int cost[] = {0,1,1};
        int k = 2 , w = 0;
        System.out.println(sol.findMaximizedCapital(k,w,profit,cost));
    }
}
