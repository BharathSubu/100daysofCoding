// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph

import java.util.*;

class DetectCycleInDirectedGraph {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);
        
        boolean isParent[] = new boolean[V];
        Arrays.fill(isParent, true);
        
        boolean dp[] = new boolean[V];
        Arrays.fill(dp, true);
        
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                isParent[j] = false;
            }
        } 
        
        boolean isThereParent = false;
        for (int i = 0; i < V; i++) {
           if(isParent[i]) {
             isThereParent = true;
             boolean ans = dfs(i,adj,vis,dp);
             if(ans) return ans;
           }
        }
        
        if(isThereParent)
        return false;
        
        return true;
    }

    private boolean dfs(int i, ArrayList<ArrayList<Integer>> map, boolean[] vis,boolean[] dp) {
        if(dp[i] == false) return false;
        vis[i] = true;
        for (int j : map.get(i)) {
            if(vis[j]) return true;
            boolean ans = dfs(j, map, vis,dp);
            if(ans) return ans;
        }
        vis[i] = false;
        dp[i] = false;
        return false;
    }
}