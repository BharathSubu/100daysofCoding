//https://practice.geeksforgeeks.org/problems/geeks-training/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geeks-training
public class NinjaTraining {
    public int maximumPoints(int points[][],int N){
        //code here
    }


    //tabulation
    public int tabulationMaximumPoints(int points[][],int n){
        for(int i = n-2 ; i >= 0 ; i--){
            points[i][0]+=Math.max( points[i+1][1], points[i+1][2]);
            points[i][2]+=Math.max( points[i+1][1], points[i+1][0]);
            points[i][1]+=Math.max( points[i+1][0], points[i+1][2]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<3;i++){
            max = Math.max(points[0][i],max);
        }
        return max;
    }
}
