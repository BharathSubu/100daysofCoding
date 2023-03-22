
import java.util.*;

public class NumberOfSubarraysOf0s {
    long no_of_subarrays(int N, int [] arr) {
        long ans=0;
        long cnt=0;
        for(var in:arr)
        {
            if(in==0)
            {
                cnt++;
            }
            else
            {
                ans+=((long)(cnt*(cnt+1))/2);
                cnt=0;
            }
        }
        if(cnt!=0)
        {
            ans+=((long)(cnt*(cnt+1))/2);
        }
        return ans;
    }
}
