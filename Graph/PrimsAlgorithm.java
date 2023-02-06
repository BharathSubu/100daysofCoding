//https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
import java.util.*;

public class PrimsAlgorithm {
    static class Pair{
        int node , parent , cost;
        Pair(int cost,int node , int parent){
            this.cost = cost;
            this.node = node;
            this.parent  = parent;
        }
    }
    static int spanningTree(int V, int E, int edges[][]){

        //to store all edges of the MST
        List<int[]> lst = new ArrayList<>();
        //sum of all edges
        int sum = 0;

        HashMap<Integer,List<Pair>> map = new HashMap<>();
        for(int [] e :edges){
            int u = e[0];
            int v = e[1];
            int cost = e[1];
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(new Pair(cost,v,u));
            map.get(v).add(new Pair(cost,u,v));
        }

        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);

        PriorityQueue<Pair> qu = new PriorityQueue<>((a,b)->a.cost-b.cost);
        qu.add(new Pair(0,0,-1));
        while (!qu.isEmpty()){
            Pair p = qu.remove();

            if(!vis[p.node]){
                if(p.parent != -1){
                    int []l = {p.parent , p.node};
                    lst.add(l);
                    sum+=p.cost;
                }
                if(map.containsKey(p.node))
                for(Pair pr : map.get(p.node)){
                    qu.add(pr);
                }
                vis[p.node] = true;
            }
        }
        return sum;
    }
}
