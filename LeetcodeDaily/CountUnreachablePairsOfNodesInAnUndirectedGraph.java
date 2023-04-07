//https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
import java.util.*;
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    public long countPairs(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int  e[] : edges){
            int u = e[0] , v =e[1];
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        Arrays.fill(vis,false);
        long count = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                long connected = dfs(i,vis,map);
                count+=connected*(n - connected);
            }
        }
        return count/2;
    }
    long dfs(int i , boolean vis[] , HashMap<Integer,List<Integer>> map ){
        long nodes = 1;
        vis[i] = true;
        if(map.containsKey(i)){
            for(int j : map.get(i)){
                if(!vis[j]) nodes+=dfs(j,vis,map);
            }
        }
        return nodes;
    }
}
