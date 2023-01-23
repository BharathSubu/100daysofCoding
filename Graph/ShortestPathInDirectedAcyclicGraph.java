//https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

import java.util.*;

public class ShortestPathInDirectedAcyclicGraph {
//    public int[] shortestPath(int N,int M, int[][] edges) {
//
//        int[] ans = new int[N];
//        Arrays.fill(ans,-1);
//
//        HashMap<Integer,List<Integer>> map = new HashMap<>();
//        int[][] adjMat = new int[N][N];
//        Arrays.stream(adjMat).forEach(a->Arrays.fill(a,-1));
//
//        int inComing[] = new int[N];
//        Arrays.fill(inComing,0);
//        for(int [] a : edges){
//            int parent = a[0];
//            int child = a[1];
//            int cost = a[2];
//            adjMat[parent][child] = cost;
//            map.putIfAbsent(parent,new ArrayList<>());
//            map.get(parent).add(child);
//
//        }
//        HashSet<Integer> set = new HashSet<>();
//        dfs(0,set,map);
//        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()) {
//            if(set.contains(entry.getKey()))
//                for (int v: entry.getValue()){
//                    inComing[v]+=1;
//                }
//        }
//        Queue<Integer> qu = new LinkedList<>();
//        qu.add(0);
//
//        ans[0] = 0;
//        while (!qu.isEmpty()){
//            int parent = qu.remove();
//            if(map.containsKey(parent))
//            for (int c:map.get(parent)) {
//                if(ans[c] != -1)
//                    ans[c] = Math.min(ans[c],ans[parent]+adjMat[parent][c]);
//                else ans[c] = ans[parent]+adjMat[parent][c];
//                inComing[c]--;
//                if(inComing[c]==0)qu.add(c);
//            }
//        }
//        return ans;
//    }
//
//    void dfs(int i , HashSet<Integer> set , HashMap<Integer,List<Integer>> map){
//        set.add(i);
//        if(map.containsKey(i))
//            for (int j:map.get(i) ) {
//                dfs(j,set,map);
//            }
//    }
    class Pair {
        int to;
        int cost;
        Pair(int t,int c){
            to = t;
            cost = c;
        }
    }
    public int[] shortestPath(int n , int m ,int[][] edges) {

    int[] ans = new int[n];
    Arrays.fill(ans,Integer.MAX_VALUE);

    HashMap<Integer,List<Pair>> map = new HashMap<>();
    for(int [] a : edges){
        int parent = a[0];
        int child = a[1];
        int cost = a[2];
        map.putIfAbsent(parent,new ArrayList<>());
        map.get(parent).add(new Pair(child,cost));
    }
    boolean vis[] = new boolean[n];
    Arrays.fill(vis,false);

    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < n; i++) {
        if(!vis[i]) topoSort(i,st,map,vis);
    }

    while (!st.isEmpty() && st.peek() != 0) st.pop();

    ans[0] = 0;
    while (!st.isEmpty()){
        int parent = st.pop();
        if(map.containsKey(parent))
            for (Pair c:map.get(parent)) {
                ans[c.to] = Math.min(ans[c.to],ans[parent]+c.cost);
            }
    }
    for (int i = 0; i < ans.length; i++) {
        if(ans[i] ==Integer.MAX_VALUE || ans[i] < 0) ans[i] = -1;
    }
    return ans;
    }

    void topoSort(int i , Stack<Integer> st , HashMap<Integer,List<Pair>> map,boolean vis[]){
        vis[i] = true;
        if(map.containsKey(i))
            for(Pair j : map.get(i)){
                if(!vis[j.to]) topoSort(j.to,st,map,vis);
            }
        st.push(i);
    }

    public static void main(String[] args) {
        int N =5, M= 5;
        int grid[][] = {{0, 1, 2},
                {2, 1, 2},
                {2 ,4, 2},
                {1 ,4 ,8},
                {1 ,3 ,6} };
        ShortestPathInDirectedAcyclicGraph sol = new ShortestPathInDirectedAcyclicGraph();
        System.out.println(Arrays.toString(sol.shortestPath(N,M,grid)));
    }
}
