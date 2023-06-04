//https://practice.geeksforgeeks.org/problems/cbd515a00f6537180d2e66f1ffe11093a128e560/1
import java.util.*;
public class TotalCuts {
    public static int totalCuts(int N, int K, int[] A) {   // code here
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int[] B = new int[N];

        for(int i = 0;i<A.length;i++){
            B[i]=A[i];
        }

        for(int i = 0;i<A.length;i++){
            if(A[i] > max){
                max=A[i];
            }
            else A[i]=max;
        }


        for(int i = N-1;i>=0;i--){
            if(B[i] < min){
                min=B[i];
            }else B[i]=min;
        }


        int count = 0;

        for(int i = 0;i<N-1;i++){
            if(A[i]+B[i+1]>=K) count++;
        }

        return count;
    }
}
