//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
import java.util.*;
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    class Pair{
        int v,parent;
        Pair(int _v,int _parent){
            v = _v;
            parent = _parent;
        }
    }
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer,List<Pair>> map = new HashMap<>();
        for(int [] e : connections){
            int u = e[0];
            int v = e[1];
            int parent = v;
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(new Pair(v,parent));
            map.get(v).add(new Pair(u,parent));
        }
        boolean vis[] = new boolean[n];
        Arrays.fill(vis,false);
        int findCost = dfs(0,vis,map);
        return findCost;
    }

    private int dfs(int i, boolean[] vis, HashMap<Integer, List<Pair>> map) {
        int count = 0;
        vis[i]=true;
        if(map.containsKey(i))
        for(Pair p : map.get(i)){
            if(!vis[p.v]){
                if(i != p.parent) count++;
                count+=dfs(p.v,vis,map);
            }
        }
        return count;
    }

}
