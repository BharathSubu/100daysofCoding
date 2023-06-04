//https://practice.geeksforgeeks.org/problems/32dc957908c2eb8beeeaeedf81f37df20d37c308/1
import java.util.*;
public class PalindromeWithMinimumSum {
    public static int minimumSum(String str) {
        StringBuilder s = new StringBuilder(str);
        int n = s.length();
        int i = 0 , j = n-1;
        while (i<=j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else if(s.charAt(i) == '?'){
                s.setCharAt(i,s.charAt(j));
            }
            else if(s.charAt(j) == '?'){
                s.setCharAt(j,s.charAt(i));
            }
            else return -1;
        }
        i=0;
        int count = 0;
        char curr = '-';
        while (i < n ){
            while(i < n && s.charAt(i) == '?'){
                i++;
            }
            if(curr == '-') {
                curr = s.charAt(i);
            }
            else{
                count += Math.abs(s.charAt(i) - curr);
                curr= s.charAt(i);
            }
            i++;
        }
        return count;
    }
}
