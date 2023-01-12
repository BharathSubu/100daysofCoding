//https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/

import java.util.*;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {



        public int[] dfs(int node, int[] res,  HashMap<Integer,ArrayList<Integer>> adj, int parent, String s){
                int[] count = new int[26];
                for (int curr : adj.get(node)) {
                    if (curr != parent) {
                        int[] adjCount = dfs(curr, res, adj, node, s);
                        for(int i = 0; i < 26; i++){
                            count[i] += adjCount[i];
                        }
                    }
                }
                char ch = s.charAt(node);
                count[ch - 'a']++;
                res[node] = count[ch - 'a'];
                return count;
        }

        public int[] countSubTrees(int n, int[][] edges, String s) {
            HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
            for(int[] edge : edges){
                adj.putIfAbsent(edge[0],new ArrayList<>());
                adj.putIfAbsent(edge[1],new ArrayList<>());
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            int[] result = new int[n];
            dfs(0, result, adj, -1, labels);
            return result;
        }
}
