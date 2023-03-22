//https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/submissions/914924402/

import java.util.*;

public class MinimumNumberOfRemovalsToMakeMountainArray {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return 0;
        int dp[][][]= new int[n+1][n+1][3];
        Arrays.stream(dp).forEach(a->Arrays.stream(a).forEach(b->Arrays.fill(b,-1)));
        return n - find(-1,0,-1,dp,nums);
    }
    int find(int prev,int curr, int isIncreasing, int[][][]dp, int[]nums ){
        if(curr == nums.length){
            if(isIncreasing == 0) return Integer.MIN_VALUE/2;
            return 0;
        }
        if(dp[prev+1][curr][isIncreasing+1] != -1) return dp[prev+1][curr][isIncreasing+1];

        int noTake = Integer.MIN_VALUE ;
        noTake = Math.max(noTake,find(prev,curr+1,isIncreasing,dp,nums));
        int take = Integer.MIN_VALUE;
        if(prev == -1 ){
            take = Math.max(take,find(curr,curr+1,-1,dp,nums));
        }
        else {
            if((nums[curr] > nums[prev] && isIncreasing == -1)){
                take = Math.max(take,2+find(curr,curr+1,0,dp,nums));
            }
            if((nums[curr] > nums[prev] && isIncreasing == 0 )){
                take = Math.max(take,1+find(curr,curr+1,0,dp,nums));
            }
            if(nums[curr] < nums[prev] && (isIncreasing == 0 || isIncreasing == 1)){
                take = Math.max(take,1+find(curr,curr+1,1,dp,nums));
            }
        }
        return dp[prev+1][curr][isIncreasing+1] = Math.max(take,noTake);
    }
    //aproach2

    public int minimumMountainRemovals2(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return 0;
        int dp[][][]= new int[n+1][n+1][3];
        Arrays.stream(dp).forEach(a->Arrays.stream(a).forEach(b->Arrays.fill(b,-1)));
        return n - find(-1,0,-1,dp,nums);
    }
}
