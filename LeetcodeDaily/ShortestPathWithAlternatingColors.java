//https://leetcode.com/problems/shortest-path-with-alternating-colors/description/

import java.util.*;

public class ShortestPathWithAlternatingColors {
    class Pair{
        int v , color ;
        Pair(int v,int color){
            this.v = v;
            this.color = color;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer,List<Pair>> map = new HashMap<>();
        for(int red[] : redEdges){
            int u = red[0];
            int v = red[1];
            map.putIfAbsent(u,new ArrayList<>());
            map.get(u).add(new Pair(v,0));
        }
        for(int blue[] : blueEdges){
            int u = blue[0];
            int v = blue[1];
            map.putIfAbsent(u,new ArrayList<>());
            map.get(u).add(new Pair(v,1));
        }
        int dist[] = new int[n];
        int currDist[][] = new int[2][n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.stream(currDist).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));

        boolean visRed[] = new boolean[n];
        boolean visBlue[] = new boolean[n];

        Arrays.fill(visRed,false);
        Arrays.fill(visBlue,false);

        Queue<Pair> qu = new LinkedList<>();
        dist[0] = 0;
        currDist[0][0] = 0;
        currDist[1][0] = 0;
        qu.add(new Pair(0,-1));
        while (!qu.isEmpty()){
            Pair p = qu.remove();
            if(p.color!=-1)
                if(p.color == 1){
                    visBlue[p.v] = true;
                }else{
                    visRed[p.v] = true;
                }
            if(map.containsKey(p.v)){
                for(Pair q : map.get(p.v)){
                    boolean isVis = false;
                    if(q.color == 1){
                        isVis = visBlue[q.v];
                    }else{
                        isVis = visRed[q.v];
                    }
                    if(q.color != p.color && !isVis){
                        if(q.color == 0){
                            currDist[q.color][q.v] = Math.min(currDist[1][p.v] + 1,currDist[q.color][q.v]);
                            dist[q.v] = Math.min(dist[q.v],Math.min(currDist[0][q.v],currDist[1][q.v]));
                        }
                        else{
                            currDist[q.color][q.v] = Math.min(currDist[0][p.v] + 1,currDist[q.color][q.v]);
                            dist[q.v] = Math.min(dist[q.v],Math.min(currDist[0][q.v],currDist[1][q.v]));
                        }
                        qu.add(new Pair(q.v,q.color));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }
}
