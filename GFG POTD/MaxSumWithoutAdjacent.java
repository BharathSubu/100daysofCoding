import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/7a33c749a79327b2889d420dd80342fff33aac6d/1
public class MaxSumWithoutAdjacent {
    int findMaxSum(int arr[], int n) {
        int ans=0,max=0,max1=0;

        for(int i=0;i<n;i++) {
            int val = arr[i]+max;
            max = Math.max(max,max1);
            max1 = Math.max(max1,val);
            ans = Math.max(ans,val);
        }
        return ans;
    }
}

















