
//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=n-meetings-in-one-room
import java.util.*;

class Nmeeting {
    public static int maxMeetings(int start[], int end[], int n) {
        int[][] arr = new int[start.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        return arr.length - eraseOverlapIntervals(arr);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        // System.out.println(Arrays.toString(intervals));
        if (intervals == null || intervals.length < 1)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int curr = 0;
        int removal = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[curr][1] >= intervals[i][0]) {
                removal++;
                if (intervals[curr][1] >= intervals[i][1]) {
                    curr = i;
                }
            } else {
                curr = i;
            }
        }
        return removal;
    }

    public static void main(String[] args) {
        int[] start = { 86, 32, 31, 98, 37, 65, 98, 71, 99, 58, 59, 32, 52, 69, 15, 75, 4, 86, 57, 36, 83, 18, 58, 50,
                43, 29, 98, 53, 80, 5, 89, 73, 8, 97, 17, 100, 9, 21, 55, 55, 32, 74, 60, 32, 87, 72, 54 };
        int[] end = {
                126, 112, 134, 138, 89, 118, 107, 124, 126, 83, 133, 64, 124, 109, 108, 132, 111, 95, 82, 106, 86, 118,
                82, 78, 92, 55, 128, 121, 118, 95, 94, 110, 111, 146, 124, 148, 95, 146, 109, 61, 93, 126, 74, 76, 110,
                78, 91
        };
        System.out.println(maxMeetings(start, end, start.length));
    }
}
