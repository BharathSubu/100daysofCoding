//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
import java.util.*;
public class NUmberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length <= n-2) return -1;
        HashMap<Integer,List<Integer>> lst = new HashMap<>();
        for(int e[] : connections){
            int u = e[0];
            int v = e[1];
            lst.putIfAbsent(u,new ArrayList<>());
            lst.putIfAbsent(v,new ArrayList<>());
            lst.get(u).add(v);
            lst.get(v).add(u);
        }

        boolean vis[] = new boolean[n];
        Arrays.fill(vis,false);
        int count = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,lst);
            }
        }
        return count-1;
    }

    private void dfs(int i, boolean[] vis, HashMap<Integer, List<Integer>> lst) {
        vis[i] = true;
        if(lst.containsKey(i)){
            for(int j : lst.get(i)){
                if(!vis[j]) dfs(j,vis,lst);
            }
        }
    }
}
