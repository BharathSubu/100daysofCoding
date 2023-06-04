//https://practice.geeksforgeeks.org/problems/cutting-binary-string1342/1

import java.util.*;

public class CuttingBinaryString {
    static int cuts(String s)
    {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return find(0,s,dp);
    }

    private static int find(int i, String s, int[] dp) {
        if(i >= s.length()) return 0;
        if(isPowerof5(s.substring(i,s.length()))) return 1;
        if(dp[i] != -1) return dp[i];
        int minimum = Integer.MAX_VALUE;
        for (int j = i+1; j < s.length(); j++) {
           if(isPowerof5(s.substring(j,s.length()))){
               int next = find(j+1,s,dp);
               if(next<Integer.MAX_VALUE){
                   next++;
               }

               minimum = Math.min(minimum, next);
               dp[i] = minimum;
           }
        }
        return minimum;
    }

    static boolean isPowerof5(String s){
        int n = s.length();
        if(s.charAt(n-1) != '1') return false;
        int num = 0;
        int i =0;
        while(n>0){
            if(s.charAt(n-1) == '1') num+=Math.pow(2,i);
            i++;
            n--;
        }
        // System.out.println(num);
        if(num == 1) return false;
        while(num > 1){
            if(num%5 != 0) return false;
            num/=5;
        }
        return true;
    }
}
