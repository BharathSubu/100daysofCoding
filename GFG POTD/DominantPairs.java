//https://practice.geeksforgeeks.org/problems/2a1c11024ceae36363fc405e07f2fa3e2f896ef0/1
import java.util.*;
public class DominantPairs {
    public static int dominantPairs(int n, int[] arr) {
        Arrays.sort(arr,0,n/2);
        Arrays.sort(arr,n/2,n);
        int i = 0, j=n/2 , result = 0;
        while(i<n/2 && j < n){
            if(arr[i]>=5*arr[j]){
                result += (n/2 -i);
                j++;
            }else i++;
        }
        return result;
    }
}
