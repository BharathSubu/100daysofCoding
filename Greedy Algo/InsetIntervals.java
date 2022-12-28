
// https://leetcode.com/problems/insert-interval/
import java.util.*;

class InsetIntervals {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while(i < intervals.length){
            list.add(intervals[i]);
            i++;
        }
        int[][] ans = new int[list.size()][2];
        for(int j = 0; j < ans.length; j++) ans[j] = list.get(j);
        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = { {1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] narr = { 0,11 };
        System.out.println(insert(arr, narr));
    }
}