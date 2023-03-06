//https://practice.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=print-all-lcs-sequences

import java.util.*;

public class PrintAllLCSsequences {

    public List<String> all_longest_common_subsequences(String s1, String s2)
    {
        int n = s1.length() , m = s2.length();
        int dp[][] = new int[n][m];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        HashMap<Integer , HashSet<String>> map = new HashMap<>();
        find(0,0,n,m,dp,s1,s2,map);
        List<String> res = new ArrayList<>(map.get(encode(0,0,n,m)));
        Collections.sort(res);
        return res;
    }

    private int find(int i, int j, int n , int m ,int[][] dp, String s1, String s2, HashMap<Integer, HashSet<String>> map) {
        if(i >= n || j >= m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int pos = encode(i,j,n,m);
        map.putIfAbsent(pos,new HashSet<>());
        if(s1.charAt(i) == s2.charAt(j)){
            String s = ""+s1.charAt(i);
            int res = 1 + find(i+1,j+1,n,m,dp,s1,s2,map);
            int cList = encode(i+1,j+1,n,m);
            if(map.containsKey(cList) && map.get(cList).size() > 0){
                for(String add : map.get(cList) ){
                    String r = new String(s+add);
                    map.get(pos).add(r);
                }
            }
            else map.get(pos).add(s);
            return dp[i][j] = res;
        }
        else{
            String s = "";
            int res2 = find(i,j+1,n,m,dp,s1,s2,map);
            int res1 = find(i+1,j,n,m,dp,s1,s2,map);
            if(res1 >= res2){
                int cList = encode(i+1,j,n,m);
                if(map.containsKey(cList)&& map.get(cList).size() > 0){
                    for(String add : map.get(cList)){
                        map.get(pos).add(new String(add));
                    }
                }
            }
             if(res2 >= res1){
                int cList = encode(i,j+1,n,m);
                if(map.containsKey(cList) && map.get(cList).size() > 0 ){
                    for(String add : map.get(cList)){
                        map.get(pos).add(new String(add));
                    }
                }
            }
            return dp[i][j] = Math.max(res1 , res2);
        }
    }

    int encode(int i , int j , int n , int  m){
        return i*m + j;
    }

    public static void main(String[] args) {
        String s1 = "ddeaeac", s2 ="bcacbdcdffbb";
        PrintAllLCSsequences sol = new PrintAllLCSsequences();
        System.out.println(sol.all_longest_common_subsequences(s1,s2));
    }



}
