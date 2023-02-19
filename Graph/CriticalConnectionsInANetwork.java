//https://leetcode.com/problems/critical-connections-in-a-network/
import java.util.*;
public class CriticalConnectionsInANetwork {
    int time = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int disc[] = new int[n];
        Arrays.fill(disc,-1);
        int low[] = new int[n];
        Arrays.fill(low,-1);
        List<List<Integer>> bridges = new ArrayList<>();
        HashMap<Integer,List<Integer>> adjlist = new HashMap<>();
        for(List<Integer> l : connections){
            int u = l.get(0);
            int v = l.get(1);
            adjlist.putIfAbsent(u,new ArrayList<>());
            adjlist.putIfAbsent(v,new ArrayList<>());
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        dfs(0,-1,bridges,disc,low,n,adjlist);
        return bridges;
    }

    private void dfs(int i, int parent , List<List<Integer>> bridges, int[] disc, int[] low, int n, HashMap<Integer, List<Integer>> adjlist) {
        disc[i] = low[i] = time;
        time++;
        if(adjlist.containsKey(i)){
            for(int j : adjlist.get(i)){
                if (j == parent) continue;
                if(disc[j] == -1){
                    dfs(j,i,bridges,disc,low,n,adjlist);
                    low[i] = Math.min(low[i],low[j]);
                    if(low[j]>disc[i]) bridges.add(Arrays.asList(j,i));
                }
                else{
                    low[i] = Math.min(low[i], low[j]);
                }
            }
        }
    }
}
