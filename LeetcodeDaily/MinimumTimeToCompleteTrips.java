//https://leetcode.com/problems/minimum-time-to-complete-trips/
import java.util.*;
public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long start = 0 ,end = Long.MAX_VALUE;;
        long ans = end;
        while (start <= end){
            long mid = start+(end-start)/2;
            if(isPossible(time,totalTrips,mid)){
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return ans;
    }
    boolean isPossible(int time[] , int totalTrips , long mid){
        long count = 0;
        for (int i = 0; i < time.length; i++) {
            count+=mid/time[i];
            if(count >= totalTrips) return true;
        }
        return false;
    }
}
