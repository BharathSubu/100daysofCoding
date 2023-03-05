//https://practice.geeksforgeeks.org/problems/d3fd6eb758469ab11e1a812220740d1f9819be70/1

import java.util.*;

public class AvoidExplosion {
    int parent[] ; int rank[];
    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {
        parent = new int[n+1] ; rank = new int[n+1];
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < n; i++) {
            int u = mix[i][0], v = mix[i][1];
            int pu = findUPar(u), pv = findUPar(v);
            boolean flag = true;
            for(int j = 0; j < m; j++) {
                int u1 = danger[j][0], v1 = danger[j][1];
                int pu1 = findUPar(u1); int pv1 = findUPar(v1);

                if((pu == pu1 && pv == pv1) || (pu == pv1 && pv == pu1)) {
                    flag = false;
                    break;
                }
            }

            if(!flag)
                ans.add("No");
            else {
                unionBySize(u, v);
                ans.add("Yes");
            }
        }

        return ans;
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
            rank[ulp_v] = rank[ulp_v] + rank[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u] = rank[ulp_u] + rank[ulp_v];
        }
    }
    public int findUPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        int ulp = findUPar(parent[node]);
        parent[node]= ulp;
        return parent[node];
    }
}

