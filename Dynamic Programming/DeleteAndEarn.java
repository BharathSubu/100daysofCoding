//https://leetcode.com/submissions/detail/956862758/
import java.util.*;
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer,Integer> map= new TreeMap<>();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int n = map.size();
        int arr[][] = new int[n][2];
        int i = 0;
        for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) {
            int key = mapElement.getKey();
            int val = mapElement.getValue();
            arr[i][0] = key;
            arr[i][1] = val;
            i++;
        }
        Arrays.sort(arr,(a,b)->a[0] - b[0]);
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return find(0,n,dp,arr);
    }

    int find(int i , int n , int dp[] , int [][]arr){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int notake = find(i+1,n,dp,arr);
        int take = 0;
        if(i+1 < n && arr[i+1][0] == arr[i][0] + 1) {
            int prev =  arr[i+1][1];
            arr[i+1][1] = -1;
            take = arr[i][0]*arr[i][1] + find(i+2,n,dp,arr);
            arr[i+1][1] = prev;
        }
        else if(arr[i][1] != -1)
        {
            take = arr[i][0]*arr[i][1] + find(i+1,n,dp,arr);
        }
        // if(j == -1)
        return dp[i] = Math.max(take,notake);
    }
}
