//https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
import java.util.*;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int inEdges[] = new int[n];
        Arrays.fill(inEdges,0);
        for(List<Integer> e : edges){
            int u = e.get(0);
            int v = e.get(1);
            inEdges[v]+=1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < inEdges.length; i++) {
            if(inEdges[i] == 0) res.add(i);
        }
        return res;
    }
}
