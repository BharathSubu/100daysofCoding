//https://leetcode.com/submissions/detail/956887548/
import java.util.*;
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int n, int m) {
        int len = strs.length;
        int arr[][] = new int[len][2];
        int k =0;
        for(String str : strs){
            int zero = 0 , one = 0;
            for(int i =0;i<str.length();i++){
                if(str.charAt(i) == '0') zero++;
                else one++;
            }
            arr[k][0] = zero; arr[k][1] = one;
            k++;
        }
        int dp[][][] = new int[len][n+1][m+1];
        Arrays.stream(dp).forEach(a->Arrays.stream(a).forEach(b->Arrays.fill(b,-1)));
        return find(0,n,m,dp,arr);
    }
    int find(int i, int n, int m, int [][][]dp, int [][] arr){
        if(i == arr.length || n < 0 || m < 0) return 0;
        if(dp[i][n][m] != -1) return dp[i][n][m];
        int notake = find(i+1,n,m,dp,arr);
        int take = 0;
        if(n-arr[i][0] >= 0 && m-arr[i][1] >= 0) take = 1 + find(i+1,n-arr[i][0],m-arr[i][1],dp,arr);

        return dp[i][n][m] = Math.max(take , notake);
    }
}
