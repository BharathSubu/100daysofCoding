//https://leetcode.com/problems/count-ways-to-build-good-strings/
import java.util.*;
public class CountWaysToBuildGoodStrings {
    int mod = (int)Math.pow(10,9) + 7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        long dp[] = new long[high+1];
        Arrays.fill(dp,-1);
        long sum = 0;
        for(int i = low; i <= high ;i++) {
            sum+=(int)find(i,zero,one,dp);
            sum%=mod;
        }
        return (int)sum;
    }
    long find(int i , int zero , int one , long dp[]){
        if(i == 0) return 1;
        if(i < 0) return 0;
        if(dp[i]!= -1) return dp[i];
        long take0 = find(i-zero,zero,one,dp)%mod;
        long take1 = find(i-one,zero,one,dp)%mod;
        dp[i] = (take1 + take0);
        dp[i]%=mod;
        return dp[i];
    }
}
