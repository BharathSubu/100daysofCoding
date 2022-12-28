//https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

import java.util.*;

public class MinTimeToCollectAllApples {
    HashMap<Integer,List<Integer>> map ;
    int res = 0;
       public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        map = new HashMap<>();
        for (int[] is : edges) {
            map.putIfAbsent(is[0], new ArrayList<>());
            map.get(is[0]).add(is[1]);
            map.putIfAbsent(is[1], new ArrayList<>());
            map.get(is[1]).add(is[0]);
        }
        boolean []visited = new boolean[n];
        Arrays.fill(visited,false);
        dfsApp(0, hasApple,visited);
        return res;
    }

    boolean dfsApp(int i, List<Boolean> hasApple, boolean[] visited) {
        visited[i] = true;
        boolean isthere = false;
        if (map.getOrDefault(i, null) != null) {
            for (int child : map.get(i)) {
            if (!visited[child] && dfsApp(child, hasApple, visited)) {
                    res += 2;
                    isthere = true;
                }
            }
        }
        if (isthere) {
            return true;
        }
        return hasApple.get(i);
    }
}