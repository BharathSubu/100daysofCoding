//https://practice.geeksforgeeks.org/problems/90a81c305b1fe939b9230a67824749ceaa493eab/1

import java.util.*;

public class CountNumberOfFreeCell {
    long[] countZero(int N, int K, int[][] arr){

        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        long res[] = new long[K];
        int l =0;
        int count = N*N;
        for (int [] a : arr){
            int r = a[0];
            int c = a[1];
            if(!row.contains(r-1)) {
                count-=(N- col.size());
                row.add(r-1);
            }
            if(!col.contains(c-1)){
                count-=(N- row.size());
                col.add(c-1);
            }
            res[l] = count;
            l++;
        }
        return res;
    }
}
