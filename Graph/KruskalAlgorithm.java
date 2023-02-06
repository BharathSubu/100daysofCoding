//https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
import java.util.*;

public class KruskalAlgorithm {

    static int spanningTree(int V, int E, int edges[][]){
        DSUbyRank sol = new DSUbyRank(V);
        int sum = 0;
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        for (int [] e: edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            if(sol.findUPar(u) != sol.findUPar(v)){
                sol.unionByRank(u,v);
                sum+=wt;
            }
        }
        return sum;
    }
}
