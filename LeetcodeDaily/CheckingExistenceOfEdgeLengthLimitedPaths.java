//https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
import java.util.*;
public class CheckingExistenceOfEdgeLengthLimitedPaths {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] qu) {
        boolean [] res = new boolean[qu.length];
        int queries[][] = new int[qu.length][4];
        for(int i = 0;i<qu.length; i++){
            int q[] = {qu[i][0],qu[i][1],qu[i][2],i};
            queries[i] = q;
        }
        Arrays.sort(queries,(a,b)->a[2]-b[2]);
        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);
        DSU dsu = new DSU(n);
        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            boolean isGraph = false;
            while(j < edgeList.length ){
                if(edgeList[j][2] < queries[i][2]) {
                    dsu.unionByRank(edgeList[j][0], edgeList[j][1]);
                    j++;
                }
                else break;
            }
            if(dsu.findUPar(queries[i][0]) == dsu.findUPar(queries[i][1])) isGraph = true;
            res[queries[i][3]] = isGraph;
        }
        return res;
    }
    class DSU {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        public DSU(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
}
