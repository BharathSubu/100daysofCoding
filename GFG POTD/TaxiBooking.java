//https://practice.geeksforgeeks.org/problems/7995e41d167d81f14f1d4194b29ef839f52d18ba/1
import java.util.*;
public class TaxiBooking {
    public static int minimumTime(int n, int cur, int[] pos, int[] time) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            ans = Math.min(Math.abs(cur - pos[i]) * time[i] , ans);
        }
        return ans;
    }
}
