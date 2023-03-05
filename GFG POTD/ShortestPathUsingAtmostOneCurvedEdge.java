//https://practice.geeksforgeeks.org/problems/e7d81a082cda6bd1e959d943197aa3bc21b88bdb/1
import java.awt.color.ICC_ColorSpace;
import java.util.*;
class Pair{
    boolean isTaken ;
    int cost ;
    int i;
    Pair(int  _i, int _cost, boolean _isTaken ){
        i = _i;
        cost = _cost;
        isTaken = _isTaken;
    }
}
public class ShortestPathUsingAtmostOneCurvedEdge {
    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
        HashMap<Integer,ArrayList<int[]>> map = new HashMap<>();
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int w = edges.get(i).get(2);
            int cW = edges.get(i).get(3);
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            int weight[] = {v, w,cW};
            map.get(u).add(weight);
            int weight1[] = {u, w,cW};
            map.get(v).add(weight1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.cost-y.cost);
        pq.add(new Pair(a,0,false));
        int mincost = -1;

        int dp[][] = new int[n+1][2];
        Arrays.stream(dp).forEach(x->Arrays.fill(x,Integer.MAX_VALUE));
        dp[a][0] = 0;

        while (!pq.isEmpty()){
            Pair parent = pq.remove();
            if(parent.i==b) return parent.cost;
            if(map.containsKey(parent.i)){
                for(int [] g : map.get(parent.i)){
                    if(dp[g[0]][0] > parent.cost + g[1])
                    {
                        dp[g[0]][0] = parent.cost + g[1];
                        pq.add(new Pair(g[0],parent.cost + g[1],false));
                    }
                    if(!parent.isTaken && (dp[g[0]][1] > parent.cost + g[2]))
                    {
                        dp[g[0]][1] = parent.cost + g[2] ;
                        pq.add(new Pair(g[0],parent.cost + g[2],true));
                    }
                }
            }
        }
        return mincost;
    }

    public static void main(String[] args) {
        int n = 4, m = 4 , a = 2, b = 4 ;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<Integer>(Arrays.asList(1, 2, 1, 4)));
        edges.add(new ArrayList<Integer>(Arrays.asList(1, 3, 2, 4)));
        edges.add(new ArrayList<Integer>(Arrays.asList(1, 4, 3, 1)));
        edges.add(new ArrayList<Integer>(Arrays.asList(2, 4, 6, 5)));
        System.out.println(shortestPath(n,m,a,b,edges));
    }
}
