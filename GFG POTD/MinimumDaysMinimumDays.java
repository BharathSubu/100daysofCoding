//https://practice.geeksforgeeks.org/problems/f4d22b1f9d62e8bee0ff84e9fa51dc66eb5005ec/1

import java.util.*;

public class MinimumDaysMinimumDays {
    public static int getMinimumDays(int n, String s, int[] p) {
        StringBuilder concat = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i)==s.charAt(i+1)) {
                concat.append('1');
                count++;
            }
            else concat.append('0');
        }
        for (int i = 0; i < n; i++) {
            int pos = p[i];
            if(count == 0) return i;
            if((pos-1)>=0){
                if(concat.charAt(pos-1)=='1'){
                    count--;
                    concat.setCharAt(pos-1,'0');
                }
            }
            if((pos)<n-1){
                if(concat.charAt(pos)=='1'){
                    count--;
                    concat.setCharAt(pos,'0');
                }
            }
        }
        return -1;
    }
}
