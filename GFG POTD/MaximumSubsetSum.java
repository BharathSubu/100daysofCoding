//https://practice.geeksforgeeks.org/problems/e047b92794316450814b29de56cc9c6ec18371b7/1
import java.util.*;

public class MaximumSubsetSum {
    public static long findMaxSubsetSum(int N, int[] A) {
        long sum = 0;
        long max = A[0];
        for(int i = 1;i<N;i++){
            long cur = A[i] + Math.max(sum,max);
            sum = max;
            max = cur;
        }
        return Math.max(sum,max);
    }
}
