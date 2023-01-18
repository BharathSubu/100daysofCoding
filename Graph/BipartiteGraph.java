// https://leetcode.com/problems/is-graph-bipartite/

import java.util.*;

class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        ColorVisited[] lst = new ColorVisited[graph.length];
        Arrays.fill(lst, new ColorVisited(false, false));
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.putIfAbsent(i, new ArrayList<>());
            for (int g : graph[i]) {
                map.get(i).add(g);
            }
        }
        for (int i = 0; i < lst.length; i++) {
            if(!lst[i].isVisited){
                boolean ans = dfs(i, lst, map, true);
                // for (ColorVisited colorVisited : lst) {
                //     System.out.println(colorVisited.color + " ");
                // }
                if(!ans) return ans;
            }
        }
        return true;
    }

    boolean dfs(int i, ColorVisited[] lst, HashMap<Integer, List<Integer>> map , Boolean color) {
        lst[i] = new ColorVisited(color, true);
        for (int j : map.get(i)) {
            if(!lst[j].isVisited) {
                boolean ans = dfs(j, lst, map, !color);
                if(!ans) return ans;
            }
            else {
                if(lst[i].color == lst[j].color) return false;
            }
        }
        return true;
    }

    class ColorVisited {
        boolean color = false;
        boolean isVisited = false;
        ColorVisited(boolean c, boolean v) {
            color = c;
            isVisited = v;
        }
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        BipartiteGraph sol = new BipartiteGraph();
        System.out.println(sol.isBipartite(graph));
    }
}