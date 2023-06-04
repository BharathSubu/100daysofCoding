//https://practice.geeksforgeeks.org/problems/3a93b6a25a7b88e4c80a1fee00898fd8022eb108/1
import java.util.*;
public class ArrayOperations {
    public static int arrayOperations(int n, int[] arr) {
        int count = 0;
        int res = 0;
        boolean isthere = false;
        for (int i = 0; i < n; i++) {
            if(arr[i] != 0) count++;
            else {
                isthere = true;
                if(count >= 1) res++;
                count = 0;
            }
        }
        if(!isthere) return -1;
        if(arr[n-1] != 0) res++;
        return res;
    }
}
