// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

import java.util.*;

class MinimumNumberofArrowstoBurstBalloons{
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points,(first,second)-> {
            if(first[1] == second[1]) return first[0] - second[0];
            return first[1]-second[1];
        });
        for (int[] is : points) {
            System.out.println(is[0] + " "+is[1]);
        }
        int i =1;
        int count = 1;
        int currax = points[0][1];
        while(i<points.length){
            if(points[i][0] <= currax && points[i][1] >= currax) {
                i++;
            }
            else{
                count++;
                currax = points[i][1];
                i++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[][] = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShots(arr));
    }
}