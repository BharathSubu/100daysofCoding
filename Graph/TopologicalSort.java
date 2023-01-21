//https://practice.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort
import java.util.*;

public class TopologicalSort {
//    My Solution
//    static int idx = 0;
//    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
//    {
//        int[] res = new int[V];
//        idx = 0;
//        boolean isParent[] = new boolean[V];
//        Arrays.fill(isParent, true);
//
//        boolean visted[] = new boolean[V];
//        Arrays.fill(visted, false);
//
//        //ploting graph and finding parent node , that is node without zero incoming nodes
//        HashMap<Integer, List<Integer>> map = new HashMap<>();
//
//        //count no of in nodes required
//        HashMap<Integer, Integer> Needed = new HashMap<>();
//
//        for(int i = 0 ; i < adj.size() ; i++){
//            ArrayList<Integer> lst = adj.get(i);
//            if(lst.size() != 0) {
//                map.putIfAbsent(i, new ArrayList<>());
//                for(int j = 0 ; j<lst.size();j++){
//                    int num = lst.get(j);
//                    isParent[num] = false;
//                    map.get(i).add(num);
//                    Needed.put(num, Needed.getOrDefault(num, 0)+1);
//                }
//            }
//        }
//
//        for (int i = 0; i < isParent.length; i++) {
//            if(isParent[i]){
//                dfs(i,map,Needed, visted,res);
//            }
//        }
//
//        if(idx == res.length)
//            return res;
//        else {
//            int[] ans = new int[0];
//            return    ans ;
//        }
//    }
//    static void dfs(int i , HashMap<Integer, List<Integer>> map,  HashMap<Integer, Integer> Needed  ,boolean []visted ,int [] res){
//        visted[i] = true;
//        res[idx] = i;
//        idx++;
//        if(map.containsKey(i))
//            for (int j : map.get(i)) {
//                Needed.put(j, Needed.getOrDefault(j, 0)-1);
//                if(!visted[j] && Needed.get(j) ==0 )
//                    dfs(j, map,Needed, visted, res);
//            }
//    }

    //Striver answer
    private static void dfs(int node, int vis[], Stack<Integer> st,
                            ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0)
                dfs(it, vis, st, adj);
        }
        st.push(node);
    }

    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        int ans[] = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }

}
