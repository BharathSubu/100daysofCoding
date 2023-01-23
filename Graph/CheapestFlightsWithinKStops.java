//https://leetcode.com/problems/cheapest-flights-within-k-stops/

import java.util.*;

public class CheapestFlightsWithinKStops {

    class Cpair {
        int to;
        int cost;
        int step;
        Cpair(int t,int c,int s){
            to = t;
            cost = c;
            step = s;
        }
    }

    public int findCheapestPrice(int n, int[][] grid, int src, int dst, int k) {

        HashMap<Integer,List<Cpair>> map = new HashMap<>();
        for(int [] a : grid){
            int parent = a[0];
            int child = a[1];
            int cost = a[2];
            map.putIfAbsent(parent,new ArrayList<>());
            if(child != src)
                map.get(parent).add(new Cpair(child,cost,0));
        }

        Queue<Cpair> qu = new LinkedList<>();
        qu.add(new Cpair(src,0,0));

        int ans = Integer.MAX_VALUE;

        int cost[] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);

        while (!qu.isEmpty()){
            Cpair parent = qu.remove();
            if(map.containsKey(parent.to) && parent.step <= k && ans >= parent.cost )
                for(Cpair j : map.get(parent.to)){
                    Cpair child = new Cpair(j.to , parent.cost + j.cost , parent.step + 1);
                    if(cost[child.to] > child.cost && child.to != dst){
                        cost[child.to] = child.cost;
                        qu.add(child);
                    }
                    else if(child.to == dst) ans = Math.min(ans,child.cost);
                }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
