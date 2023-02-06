//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
import java.util.*;
public class SmallestNumberOfNeighborsAtAThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        long dist[][] = new long[n][n];
        Arrays.stream(dist).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
        for (int [] e : edges) {
            int u = e[0];
            int v = e[1];
            int c = e[2];
            dist[u][v] = c;
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] =0;
        }
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j],dist[i][via] + dist[via][j]);
                }
            }
        }
        int ans = 0 , cities = -1 ;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(dist[i][j]<=distanceThreshold) count++;
            }
            if(ans<=count){
                ans = count;
                cities = i;
            }
        }
        return cities;
    }
}
