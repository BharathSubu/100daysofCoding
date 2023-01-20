

//https://leetcode.com/problems/find-eventual-safe-states/

import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        //Reverse Graph and Note InComing Nodes
        int inComing[] = new int[graph.length];
        Arrays.fill(inComing,0);

        for (int i = 0; i < graph.length; i++) {
            int in = i;
            for (int j = 0; j < graph[i].length; j++) {
                int out = graph[i][j];
                map.putIfAbsent(out,new ArrayList<>());
                map.get(out).add(in);
            }
            inComing[i] = graph[i].length;
        }
        
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if(inComing[i] == 0) qu.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!qu.isEmpty()){
            int node = qu.poll();
            ans.add(node);
            if(map.containsKey(node)){
                for (int i:map.get(node)) {
                    inComing[i]-=1;
                    if(inComing[i] == 0) qu.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
