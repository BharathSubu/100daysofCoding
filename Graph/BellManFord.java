//https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-from-the-source-bellman-ford-algorithm

import java.util.*;

public class BellManFord {

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int dist[] = new int[V];
        Arrays.fill(dist,100000000);
        dist[S] = 0;
        for(int i =0; i<V-1;i++){
            for(ArrayList<Integer> lst : edges){
                int u = lst.get(0);
                int v = lst.get(1);
                int wt = lst.get(2);
                if(dist[u]+wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for (ArrayList<Integer> lst : edges) {
            int u = lst.get(0);
            int v = lst.get(1);
            int wt = lst.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int ans[] = new int[1];
                Arrays.fill(ans,-1);
                return  ans;
            }
        }
        return dist;
    }
}
