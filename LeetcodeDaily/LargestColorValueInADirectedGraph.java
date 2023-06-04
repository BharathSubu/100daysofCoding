//https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
import java.util.*;
public class LargestColorValueInADirectedGraph {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int arr[][] = new int[n][26];
        Arrays.stream(arr).forEach(a->Arrays.fill(a,0));
        int []inOrder = new int[n];
        Arrays.fill(inOrder,0);
        boolean vis[] = new boolean[n];
        Arrays.fill(vis,false);
        HashMap<Integer,List<Integer>> adjList = new HashMap<>();
        for(int e [] : edges){
            int u = e[0] , v = e[1];
            inOrder[v]+=1;
            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.get(u).add(v);
        }
        for (int i = 0; i < colors.length(); i++) {
            arr[i][colors.charAt(i) - 'a'] = 1;
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if(inOrder[i] == 0 && !vis[i]){
                Queue<Integer> qu = new LinkedList<>();
                qu.add(i);
                while (!qu.isEmpty()){
                    int parent = qu.remove();
                    vis[parent] = true;
                    if(adjList.containsKey(parent)){
                        for(int child : adjList.get(parent)){
                            inOrder[child]--;
                            for (int j = 0; j < 26; j++) {
                                arr[child][i]+=arr[parent][i];
                                ans = Math.max(ans,arr[child][i]);
                            }
                            if(inOrder[child] == 0) qu.add(child);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(inOrder[i] != 0) return -1;
        }
        return 5;
    }
}
