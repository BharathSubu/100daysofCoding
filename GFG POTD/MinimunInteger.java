//https://practice.geeksforgeeks.org/problems/1ccf56f107bcb24242469ea45c02f852165a2184/1
import java.util.*;
public class MinimunInteger {
    public static int minimumInteger(int N, int[] A) {
        long sum=0;
        Arrays.sort(A);
        for(int i=0;i<N;i++)
        {
            sum+=A[i];
        }
        if(N==1)
        {
            return A[0];
        }
        for(int i=0;i<N;i++)
        {
            if(sum<=(long)((long)N*(long)A[i]))
            {
                return A[i];
            }
        }
        return A[0];
    }
}
