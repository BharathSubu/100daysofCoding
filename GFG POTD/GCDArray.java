//https://practice.geeksforgeeks.org/problems/2b70d42632a4e207569c6d2d777383e4603d6fe1/1

import java.util.*;

public class GCDArray {
    public static int solve(int N, int K, int[] arr) {
        for(int i=1;i<N;i++) arr[i]+=arr[i-1];
        ArrayList<Integer> factor = new ArrayList<>();
        for(int i=1;i*i<=arr[N-1];i++) {
            if(arr[N-1]%i==0) {
                factor.add(i);
                factor.add(arr[N-1]/i);
            }
        }

        int ans=1;
        for(int fact : factor) {
            int count=0;
            for(int a : arr) {
                if(a%fact==0) {
                    count++;
                }
            }
            if(count>=K) ans=Math.max(ans,fact);
        }
        return ans;
    }
}
