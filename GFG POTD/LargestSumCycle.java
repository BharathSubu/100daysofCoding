
//https://practice.geeksforgeeks.org/problems/51afa710a708c0681748445b509696dd588d5c40/1

import java.util.*;

public class LargestSumCycle {

    long ans = -1;

    public long largesSumCycle(int n, int edge[]){

        long dist[] = new long[n];
        Arrays.fill(dist,Integer.MIN_VALUE);

        boolean vis[] = new boolean[n];
        Arrays.fill(vis,false);

        for(int i = 0;i<n;i++){
            if(!vis[i]){
                search(i,0,dist,vis,edge);
            }
        }

        return ans;
    }
    private void search(int i, long prev, long[] dist, boolean[] vis, int[] edge) {

        if(dist[i] > -1){
            ans = Math.max(ans,prev+i-dist[i]);
            return;
        }

        if(vis[i]==true)
            return;

        vis[i] = true;
        dist[i] = Math.max(dist[i],i + prev);

        if(edge[i]!=-1)
            search(edge[i],i+prev,dist,vis,edge);

        dist[i] = -1;
    }



    public static void main(String[] args) {
        LargestSumCycle sol = new LargestSumCycle();
        int n = 10 ;
        int edge[] = {8 ,6, 5 ,8, 8 ,8 ,8, 3, 7, 3} ;
        System.out.println(sol.largesSumCycle(n,edge));
    }

}
