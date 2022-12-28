// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-platforms
import java.util.*;

class MiniPlatforms
{
    public static int findPlatform(int arr[], int dep[], int n) {
       Arrays.sort(arr);
        Arrays.sort(dep);
        int pN = 1 , res = 1; 
        int i = 1 , j = 0;
        while(i<n && j<n){
            if(arr[i] <= dep[j]){
                pN++;
                i++;
            }
            else if( arr[i] > dep[j] ) {
                pN--;
                j++;
            }
            res = Math.max(res, pN);
        }
        return res;
    }

}