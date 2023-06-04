//https://leetcode.com/problems/uncrossed-lines/
import java.util.*;
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
      int n1 = nums1.length , n2 = nums2.length;
      int  dp[][] = new int[n1][n2];
      Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
      return find(0,0,n1,n2,nums1,nums2,dp);
    }

    private int find(int i, int j, int n1, int n2, int[] nums1, int[] nums2, int[][] dp) {
        if(i == n1 || j == n2) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int noTake = find(i+1,j+1,n1,n2,nums1,nums2,dp);
        int noTake1 = find(i+1,j,n1,n2,nums1,nums2,dp);
        noTake = Math.max(noTake1,noTake);
        int noTake2 = find(i,j+1,n1,n2,nums1,nums2,dp);
        noTake = Math.max(noTake2,noTake);
        int take = Integer.MIN_VALUE;
        if(nums1[i] == nums2[j]) take = 1 + find(i+1,j+1,n1,n2,nums1,nums2,dp);
        return dp[i][j] = noTake = Math.max(take,noTake);
    }
}
