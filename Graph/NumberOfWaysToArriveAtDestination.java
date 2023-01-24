//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

import java.util.*;

public class NumberOfWaysToArriveAtDestination {

    class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList < ArrayList < Pair >> adj = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList < > ());
        }
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        PriorityQueue < Pair > pq = new PriorityQueue <> ((x, y) -> x.first - y.first);

        int[] dist = new int[n];
        long[] ways = new long[n];
        Arrays.fill(dist, (int)1e18);
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        int mod = (int)(1e9 + 7);
        while (pq.size() != 0) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                }
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return (int)ways[n - 1];
    }
}
