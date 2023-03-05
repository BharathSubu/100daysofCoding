//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
import java.util.*;
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int start = 1 , end = 0;
        for (int i = 0; i < weights.length; i++) {
            end+=weights[i];
        }
        int ans = end;
        while (start<=end){
            int mid = (start+end)/2;
            if(isPossible(weights,days,mid)) {
                ans = mid;
                end = mid-1;
            } else start = mid + 1;
        }
        return ans;
    }
    boolean isPossible(int [] weights , int days, int weight){
        int currW = 0;
        int count = 1;
        int i = 0;
        while (i<weights.length){
            if(weights[i] > weight) return false;
            if((currW + weights[i]) > weight) {
                count++;
                currW = 0;
            }
            currW+=weights[i];
            i++;
        }
        if(count<=days)return true;
        return false;
    }
}
