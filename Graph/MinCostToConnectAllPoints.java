//https://leetcode.com/problems/min-cost-to-connect-all-points/

import javax.swing.*;
import java.util.*;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {

        DSU sol = new DSU(points.length);
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < points.length -1; i++) {
            for (int j = i+1; j < points.length; j++) {
                int u = i;
                int v = j;
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                List<Integer> l = new ArrayList<>();
                Collections.addAll(l, u,v,w);
                edges.add(l);
            }
        }
        Collections.sort(edges,(a,b)->a.get(2)-b.get(2));
        int cost = 0;
        for(List<Integer> adj : edges){
            int u = adj.get(0);
            int v = adj.get(1);
            int wt = adj.get(2);
            if(sol.findUPar(u)!=sol.findUPar(v)){
                sol.unionBySize(u,v);
                cost+=wt;
            }
        }
        return cost;
    }
}
