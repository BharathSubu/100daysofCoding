//https://leetcode.com/problems/network-delay-time/

import  java.util.*;

public class NetworkDelayTime {

    class Pair {
        int to;
        int cost;
        Pair(int t,int c){
            to = t;
            cost = c;
        }
    }
    public int networkDelayTime(int[][] edges, int n, int k) {
        n++;
        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);

        HashMap<Integer,List<Pair>> map = new HashMap<>();
        for(int [] a : edges){
            int parent = a[0];
            int child = a[1];
            int cost = a[2];
            map.putIfAbsent(parent,new ArrayList<>());
            if(child != k)
                map.get(parent).add(new Pair(child,cost));
        }
        Queue<Integer> qu = new LinkedList<>();
        qu.add(k);
        ans[k] = 0;
        while (!qu.isEmpty()){
            int parent = qu.remove();
            if(map.containsKey(parent)){
                for (Pair j : map.get(parent)) {
                    int a = ans[parent] + j.cost;
                    if(a < ans[j.to]){
                        ans[j.to] = a;
                        qu.add(j.to);
                    }
                }
            }
        }
        int res = -1;
        for (int i = 1; i < ans.length; i++) {
            if(ans[i] != Integer.MAX_VALUE && i != k)
            {
                res = Math.max(res,ans[i]);
            }
            if(ans[i] == Integer.MAX_VALUE) return -1;
        }
        return res;
    }


}
