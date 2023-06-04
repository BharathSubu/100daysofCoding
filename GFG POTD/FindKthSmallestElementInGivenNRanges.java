//https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-given-n-ranges/1
import java.util.*;
public class FindKthSmallestElementInGivenNRanges {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] target) {
        Arrays.sort(range,(a,b)->a[0]-b[0]);
        range = merge(range);
        n = range.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        int presum[] = new int[n];
        presum[0] = range[0][1] - range[0][0] + 1;
        for(int i = 1;i<n;i++){
            presum[i] = range[i][1] - range[i][0] + 1 + presum[i-1];
        }
        for(int i =0;i<q;i++)
        {
            int findIdx = binarySearch(presum,target[i]);
            if(findIdx == -1){
                res.add(findIdx);
                continue;
            }
            if(findIdx == 0){
                int ans = range[0][0] + target[i]-1;
                res.add(ans);
            }
            else{
                int ans = target[i] - presum[findIdx-1] - 1;
                ans+=range[findIdx][0];
                res.add(ans);
            }
        }
        return res;
    }
    public static int binarySearch(int presum[],int target){
        int n = presum.length;
        int start = 0 , end =n-1;
        if(target <= presum[0]) return 0;
        if(target > presum[n-1]) return -1;
        while(start < end){
            int mid = (start + end)/2;
            // System.out.println(start+" "+mid+" "+end);
            if(presum[mid] == target) return mid;
            else if(mid+1 < n && presum[mid+1] > target && presum[mid] < target) return mid+1;
            else if(target > presum[mid]) start = mid+1;
            else end = mid -1;
        }

        return -1;
    }

    public static int[][] merge(int[][] intervals) {
        int [][] combined = new int[intervals.length][2];
        int k = 0;
        combined[0] = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(combined[k][1] >= intervals[i][0]){
                if(combined[k][1] < intervals[i][1])
                    combined[k][1] = intervals[i][1];
            }
            else{
                k++;
                combined[k] = intervals[i];
            }
        }
        int [][] res = new int[k+1][2];
        for(int i = 0; i < k+1; i++){
            res[i] = combined[i];
        }
        return res;
    }
}
