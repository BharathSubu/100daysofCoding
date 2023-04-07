//https://leetcode.com/problems/longest-cycle-in-a-graph/
import java.util.*;
public class LongestCycleInAGraph {

    public int longestCycle(int[] edges) {
        int n = edges.length;
        int len = -1;
        boolean vis[] = new boolean[n];
        Arrays.fill(vis,false);
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            if(!vis[i]) {
                vis[i] = true;
                int slow = i;
                int fast = i;
                boolean isCycle = false;
                while (edges[fast] != -1 && edges[edges[fast]] != -1) {
                    slow = edges[slow];
                    fast = edges[edges[fast]];
                    if(slow == fast){
                        int cycleLen = 1;
                        slow = edges[slow];
                        while (slow != fast) {
                            cycleLen++;
                            slow = edges[slow];
                        }
                        len = Math.max(len,cycleLen);
                        memo[i] = cycleLen;
                        vis[i] = true;
                        break;
                    }
                    if (memo[slow] != 0) {
                        memo[i] = memo[slow];
                        vis[i] = true;
                        break;
                    }
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LongestCycleInAGraph sol = new LongestCycleInAGraph();
        int edges [] = {1,2,0,4,5,6,3,8,9,7};
        System.out.println(sol.longestCycle(edges));
    }
}
