// https://leetcode.com/problems/maximum-sum-circular-subarray/description/

import java.util.*;

class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] arr) {
        int n = arr.length;
        int nums[] = new int[2*n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i%n];
        }
        int globalSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start= 0 ;
        n = nums.length/2;
        for(int i=0; i<nums.length;i++){
            currentSum += nums[i];
            if(i - start >= n ) {
                currentSum -= nums[start];
                int sum = currentSum;
                int startMove =  start++;
                while(startMove <= i){
                    globalSum = Math.max(globalSum,sum);
                    sum -= nums[startMove];
                    startMove++;
                }
            }
            if (currentSum > globalSum){
                globalSum = currentSum;
            }
            if (currentSum<0){
                currentSum=0;
                start = i+1;
            }
        }
        return globalSum;
    }
    public static int maxSum2(int[] nums){
        int globalSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start=0;
        int end=0;
        int n = nums.length/2;
        for(int i=0; i<nums.length;i++){
            currentSum += nums[i];

            if (currentSum>globalSum){
                globalSum = currentSum;
                end = i;
            }
            if (currentSum<0){
                currentSum=0;
                start = i+1;
            }
            System.out.println(currentSum+" "+globalSum);
            if(end - start > n) {
                currentSum -= nums[start];
                start++;
            }
        }
//        System.out.println(start + " " + end);
        return globalSum;
    }
}