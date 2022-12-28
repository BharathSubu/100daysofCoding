
import java.util.*;

// https://leetcode.com/problems/candy/

class Candy {
    public int candy(int[] ratings) {
        int minres = 0;
        int arr[] = new int[ratings.length];
        Arrays.fill(arr, 1);
        int n = ratings.length ;
        for (int i = 0; i < n; i++) {
            boolean ismx = false;
            int max = arr[i];
            if(i-1 > -1){
                if(ratings[i-1] < ratings[i]) {
                    ismx = true;
                    max = Math.max(max, arr[i-1]);
                }
            }
            if(i+1< n){
                if(ratings[i+1] < ratings[i]) {
                    ismx = true;
                    max = Math.max(max, arr[i+1]);
                }
            }
            if(ismx){
                arr[i] = max + 1;
            }
        }
       
        for (int i = n-1; i >= 0; i--) {
            boolean ismx = false;
            int max = -1;
            if(i-1 > -1){
                if(ratings[i-1] < ratings[i]) {
                    ismx = true;
                    max = Math.max(max, arr[i-1]);
                }
            }
            if(i+1< n){
                if(ratings[i+1] < ratings[i]) {
                    ismx = true;
                    max = Math.max(max, arr[i+1]);
                }
            }
            if(ismx){

                arr[i] = max + 1;
            }
            minres+=arr[i];
        }
       
        return minres;
    }
}   