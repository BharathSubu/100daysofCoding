//https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities
import java.util.*;
public class MinimumScoreOfAPathBetweenTwoCities {
    class Pair{
        int to , cost;
        Pair(int t , int c){
            to = t;
            cost = c;
        }
    }

    public int minScore(int n, int[][] roads) {
        HashMap<Integer,List<Pair>> map = new HashMap<>();

        for(int a[] : roads){
            int from = a[0];
            int to = a[1];
            int cost = a[2];
            map.putIfAbsent(from,new ArrayList<>());
            map.putIfAbsent(to,new ArrayList<>());
            map.get(from).add(new Pair(to,cost));
            map.get(to).add(new Pair(from,cost));
        }

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(1,Integer.MAX_VALUE));

        int res = Integer.MAX_VALUE;
        boolean vis[] = new boolean[n+1];
        Arrays.fill(vis,false);

        while(!qu.isEmpty()){
            Pair p = qu.remove();
            int city = p.to;
            int cost = p.cost;
            vis[city] = true;
            res = Math.max(res,cost);
            if(map.containsKey(city)){
                for(Pair j : map.get(city)){
                    if(!vis[j.to]) qu.add(new Pair(j.to,j.cost));
                }
            }
        }
        return res;
    }
}
