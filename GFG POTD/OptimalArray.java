//https://practice.geeksforgeeks.org/problems/d4aeef538e6dd3280dda5f8ed7964727fdc7075f/1
import java.util.*;
public class OptimalArray {
    public long[] optimalArray(int n,int a[])
    {
        long ans[] = new long[n];
        int idx = 0 , s1 = 0,s2=0;
        for (int i = 0; i < (n+1)/2; i++) {
            s1+=a[i];
            if(2*i < n){
                s2+=a[2*i];
                int curr = ((i+1)*a[i] - s1) + (s2-s1) - i*a[i];
                ans[idx++] = curr;
            }
            if(2*i+1<n){
                s2+=a[2*i+1];
                int curr = ((i+1)*a[i] - s1) + (s2-s1) - (i+1)*a[i];
                ans[idx++] = curr;
            }
        }
        return ans;
    }
}
