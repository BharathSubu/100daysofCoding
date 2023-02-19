//https://leetcode.com/problems/find-center-of-star-graph/
import java.util.*;
public class StarGraph {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            map.put(u,map.getOrDefault(u,0)+1);
            map.put(v,map.getOrDefault(v,0)+1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == edges.length) ans = entry.getValue();
        }
        return ans;
    }
}
