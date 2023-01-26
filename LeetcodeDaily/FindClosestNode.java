// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
import java.util.*;
class FindClosestNode {

    public void dfs(int node, int[] edges, int[] dist, boolean[] visited) {
        visited[node] = true;
        int adjacent = edges[node];
        if (adjacent != -1 && !visited[adjacent]) {
            dist[adjacent] = dist[node] + 1;
            dfs(adjacent, edges, dist, visited);
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int ans = -1;
        int minDist = Integer.MAX_VALUE;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        boolean[] vis1 = new boolean[n];
        boolean[] vis2 = new boolean[n];
        dfs(node1, edges, dist1, vis1);
        dfs(node2, edges, dist2, vis2);

        for (int currNode = 0; currNode < n; currNode++) {
            if (vis1[currNode] && vis2[currNode] && minDist > Math.max(dist1[currNode], dist2[currNode])) {
                minDist = Math.max(dist1[currNode], dist2[currNode]);
                ans = currNode;
            }
        }
        return ans;
    }
}