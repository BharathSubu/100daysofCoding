import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            sum+=cardPoints[i];
            System.out.println(cardPoints[i]);
        }
        max = Math.max(max, sum);
        int start = cardPoints.length - k;
        for (int i = 0; i < k; i++) {
            sum+=cardPoints[i];
            sum-=cardPoints[start+i];
            max = Math.max(max, sum);
        }
        return max;
    }
    public static void main(String[] args) {
        MaximumPointsYouCanObtainfromCards sol  = new MaximumPointsYouCanObtainfromCards();
        int arr[] = {96,90,41,82,39,74,64,50,30};
        System.out.println(sol.maxScore(arr, 8));
    }
}