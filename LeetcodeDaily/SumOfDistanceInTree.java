import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/sum-of-distances-in-tree/
public class SumOfDistanceInTree {
    HashMap<Integer,List<Integer>> map ;
    int res = 0;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        map = new HashMap<>();
        for(int[]is:edges){
            map.putIfAbsent(is[0], new ArrayList<>());
            map.get(is[0]).add(is[1]);

        }
        System.out.println(map);
        int visited[] = new int[n];
        DFS(0,0,hasApple);
        return  res;
    }
    void DFS(int i,int dis, List<Boolean> hasApple){
        System.out.println(i);
        if(map.getOrDefault(i,null) == null) return;
        for(int child : map.get(i)){
            DFS(child, dis ,hasApple);
        }
    }

}
