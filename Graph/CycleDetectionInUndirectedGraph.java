//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph

import java.util.*;

public class CycleDetectionInUndirectedGraph {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);

        for (int i = 0; i < V; i++) {
            if(!vis[i]) {
                boolean ans = dfs(i,adj,vis,-1);
                if(ans) return ans;
            }
        }
        return false;

    }

    private boolean dfs(int i, ArrayList<ArrayList<Integer>> map, boolean[] vis,int parent) {

        vis[i] = true;

        for (int j : map.get(i)) {

            if(j!=parent){
                if(vis[j]) return true;
                boolean ans = dfs(j, map, vis,i);
                if(ans) return ans;
            }

        }

        return false;
    }
}
