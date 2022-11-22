//https://leetcode.com/problems/perfect-squares/

import java.util.*;

public class PerfectSquare {
    public static  int numSquares(int n) {
        int cap = n*(n+1);
        int dp[] = new int[cap];
        dp[0] = 0;
        for (int i = 1; i < n+1; i++) {
            dp[i] = i;
            for (int s = 1 ; s < i+1 ; s++){
                int square = s*s;
                if(i - square < 0) break;
                dp[i] = Math.min( dp[i], 1 + dp[i-square]);

            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
