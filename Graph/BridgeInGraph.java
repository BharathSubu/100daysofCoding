//https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bridge-edge-in-graph
import java.util.*;
public class BridgeInGraph {
    List<Integer>  order(int city_node,List<Integer> from , List<Integer> to , int company){
        List<Integer> res = new ArrayList<>();

        //creating adjList
        HashMap<Integer,List<Integer>> adjlist = new HashMap<>();
        for (int i = 0; i < from.size(); i++) {
            int u = from.get(i);
            int v = to.get(i);
            adjlist.putIfAbsent(u,new ArrayList<>());
            adjlist.putIfAbsent(v,new ArrayList<>());
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }

        //visted array
        boolean vis[] = new boolean[city_node+1];
        Arrays.fill(vis,false);

        //starting pos
        vis[company] = true;

        //dfs
        dfs(company,res,vis,adjlist);

        //removing source
        res.remove(0);

        return res;
    }
    void dfs(int i , List<Integer> res ,boolean vis[],HashMap<Integer,List<Integer>> adjlist){
        vis[i] = true;
        res.add(i);
        if(adjlist.containsKey(i))
            for(int j : adjlist.get(i)){
                if(!vis[j]) dfs(j,res,vis,adjlist);
            }
    }

    public static void main(String[] args) {
        BridgeInGraph sol = new BridgeInGraph();
        int edges = 4;
        List<Integer> from = new ArrayList<>();
        Collections.addAll(from,1,2,2);

        List<Integer> to = new ArrayList<>();
        Collections.addAll(to,2,3,4);

        System.out.println(sol.order(edges,from,to,1));
    }
}
