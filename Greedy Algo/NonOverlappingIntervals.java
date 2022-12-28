// https://leetcode.com/problems/non-overlapping-intervals/solutions/?topicTags=greedy
import java.util.*;
class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length< 1)return 0;		
        Arrays.sort(intervals,(a,b) -> a[1] -b[1]);
        int curr = 0;
        int removal = 0;
        for (int i = 1; i < intervals.length; i++) 
        {
            if (intervals[curr][1] > intervals[i][0])
            {
                removal++;
                if (intervals[curr][1] >= intervals[i][1])
                {
                 curr = i;
                }
            }
            else
            {
                curr = i;
            }
        }
        return removal;
    }
}