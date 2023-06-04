//https://practice.geeksforgeeks.org/problems/5ae4f296db3e6bb74641c4087d587b6f89d9d135/1

import java.util.*;

public class FindTotalTimeTaken {
    public static long totalTime(int n,int arr[],int time[])
    {
        long ans=0;
        HashSet<Integer>s=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(s.contains(arr[i]))
            {
                ans+=time[arr[i]-1];
            }
            else{
                ans++;

            }
            s.add(arr[i]);
        }
        return ans-1;
    }
}
