//https://practice.geeksforgeeks.org/problems/899540d741547e2d75d1c5c03a4161ab53affd13/1
import java.util.*;

public class MaxMinHeight {
    long maximizeMinHeight(int n, int k, int w,int [] a)
    {
        long ans = -1;
        long min = Arrays.stream(a).min().getAsInt();
        long max = Integer.MAX_VALUE/2;

        while(min <= max){
            int mid = (int)(min+max)/2;
            if(isPossible(a,k,w,mid)){
                ans = mid;
                min = mid + 1;
            }
            else max = mid -1;
        }
        return ans;
    }
    boolean isPossible(int [] h ,int d,int c,long min){
        int n = h.length;
        long[] w = new long[n];
        if(h[0] < min){
            w[0] = min - h[0];
            d-=(min-h[0]);
        }
        if(d<0) return false;
        for(int i=1; i<n ; i++){
            w[i] = w[i-1];
            int ac = h[i];
            if(i >= c){
                ac += (w[i] - w[i-c]);
            }
            else ac += w[i];

            if(ac < min){
                w[i] += (min -ac);
                d -= (min - ac);
            }
            if(d < 0) return false;
        }
        return true;
    }
}
