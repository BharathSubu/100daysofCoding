//https://leetcode.com/problems/shortest-common-supersequence/
import java.util.*;
public class ShortestCommonSupersequence {

    public String shortestCommonSupersequence(String s1, String s2)
    {
        int n = s1.length() , m = s2.length();
        String dp[][] = new String[n][m];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,"null"));
        String str = find(0,0,n,m,dp,s1,s2);
        int i = 0;
        int j = 0;
        int k = 0;
        String res = "";
        while(i!=n || j != m){
            if(k<str.length()){
                while(str.charAt(k) != s1.charAt(i)) {
                    res += s1.charAt(i);
                    i++;
                }
                while(str.charAt(k) != s2.charAt(j)) {
                    res += s2.charAt(j);
                    j++;
                }
                if(str.charAt(k) == s1.charAt(i) && s1.charAt(i) == s2.charAt(j)) {
                    res += str.charAt(k);
                    k++;
                    j++;
                    i++;
                }
            }
            else{
                if(i < n){
                    while(i<n) {
                        res += s1.charAt(i);
                        i++;
                    }
                }
                if(j<m){
                    while(j<m) {
                        res += s2.charAt(j);
                        j++;
                    }
                }
            }
        }
        return res;
    }

    private String find(int i, int j, int n , int m ,String[][] dp, String s1, String s2) {
        if(i >= n || j >= m) return "";
        if(dp[i][j]!="null") return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            String s = ""+s1.charAt(i);
            String res = find(i+1,j+1,n,m,dp,s1,s2);
            return dp[i][j] = new String(s+res);
        }
        else{
            String s = "";
            String res2 = find(i,j+1,n,m,dp,s1,s2);
            String res1 = find(i+1,j,n,m,dp,s1,s2);
            if(res1.length() >= res2.length()){
                s = res1;
            }
            else {
               s = res2;
            }
            return dp[i][j] = new String(s);
        }
    }
}
