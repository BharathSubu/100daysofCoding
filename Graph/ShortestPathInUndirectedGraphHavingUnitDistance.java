//https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

import java.util.*;

public class ShortestPathInUndirectedGraphHavingUnitDistance {


    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        int ans[] = new int[n];
        Arrays.fill(ans,-1);
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int [] a :edges){
            int p = a[0] , e = a[1];
            map.putIfAbsent(p,new ArrayList<>());
            map.putIfAbsent(e,new ArrayList<>());
            map.get(p).add(e);
            map.get(e).add(p);
        }
        Queue<Integer> qu = new LinkedList<>();
        qu.add(src);
        ans[src] = 0;
        while (!qu.isEmpty()){
            int node = qu.remove();
            if(map.containsKey(node))
                for(int j : map.get(node)){
                    if(ans[j] == -1){
                        ans[j] = ans[node] + 1;
                        qu.add(j);
                    }
                }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 9, m = 10;
        int grid[][] = {
                {0 ,1},{0, 3}, {3 ,4},{4 ,5},{5, 6},
                {1, 2},{2 ,6},{6 ,7},{7, 8},{6 ,8}
                };
        int src = 5;
        ShortestPathInUndirectedGraphHavingUnitDistance sol = new ShortestPathInUndirectedGraphHavingUnitDistance();
        System.out.println(Arrays.toString(sol.shortestPath(grid,n,m,src)));
    }
}
