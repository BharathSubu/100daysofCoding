//https://leetcode.com/problems/all-paths-from-source-to-target/description/

import  java.util.*;

public class AllPathsFromSourceToTarget {
    static List<List<Integer>> res = new ArrayList<>();
    static public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> arr = new ArrayList<>();
            for(int edge : graph[i]){
                arr.add(edge);
            }
            map.put(i,new ArrayList<>(arr));
        }
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        dfs(0,arr,map,graph.length);
        return res;
    }

    static void dfs(int i, List<Integer> arr, HashMap<Integer, List<Integer>> map,int n) {
        if(i==n-1){
            System.out.println(res);
            res.add(new ArrayList<>(arr));
            return;
        }
        List<Integer> lst = map.getOrDefault(i,null);
        if(lst != null){
            for ( int edge : lst ) {
                arr.add(edge);
                dfs(edge,arr,map,n);
                arr.remove(arr.size() -1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] g = {{},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(g));
    }
}
