
//https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/

import javax.sql.rowset.serial.SerialArray;
import java.util.*;

public class MinimumFuelCostToReportToTheCapital {
    int ans = -1;
    int prev = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        HashMap<Integer,List<Integer>> adjList = new HashMap<>();
        for(int [] r  :roads){
            int u = r[0];
            int v = r[1];
            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.putIfAbsent(v,new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean vis[] = new boolean[roads.length+1];
        Arrays.fill(vis,false);
        dfs(0,0,vis,seats,adjList);
        return ans;
    }

    private int dfs(int i, int count, boolean[] vis, int seats, HashMap<Integer, List<Integer>> adjList) {
        int people = 1;
        vis[i] = true;
        if(adjList.containsKey(i))
            for(int j : adjList.get(i)){
                if(!vis[j]){
                    people+=(dfs(j,count,vis,seats,adjList));
                }
            }

        if (i != 0) ans += (people + seats - 1) / seats;
        return people;
    }

    class Pair{
        int cost = 0;
        int have = 0;
        Pair(int c,int h){
            cost = c;
            have = h;
        }
    }
}
