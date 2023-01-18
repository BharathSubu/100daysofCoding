//https://leetcode.com/problems/longest-path-with-different-adjacent-characters/description/

import java.util.*;

public class LongestPathWithDifferentAdjacentCharacters {
    int res = 1;
    public int longestPath(int[] parent, String s) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            map.putIfAbsent(i,new ArrayList<>());
            map.putIfAbsent(parent[i],new ArrayList<>());
//            map.get(i).add(parent[i]);
            map.get(parent[i]).add(i);
        }
//        System.out.println(map);
        dfs(0,map,s);
        return res;
    }
    public int dfs(int parent, HashMap<Integer,List<Integer>> map , String s){
        int longest = 0, secLongest = 0;
        int pathLen ;
        if(map.containsKey(parent))
        for ( int child : map.get(parent) ) {
            pathLen = dfs(child,map,s);
            if(s.charAt(child) != s.charAt(parent)){
                if(pathLen > longest) {
                    secLongest = longest;
                    longest = pathLen;
                } else if (pathLen > secLongest) {
                    secLongest = pathLen;
                }
            }
        }
        res = Math.max(res ,( longest + secLongest + 1));
        return longest + 1;
    }

    public static void main(String[] args) {
        LongestPathWithDifferentAdjacentCharacters sol = new LongestPathWithDifferentAdjacentCharacters();
        int [] parent = {-1,0,0,0};
        String s = "aabc";
        System.out.println(sol.longestPath(parent,s));
    }
}
