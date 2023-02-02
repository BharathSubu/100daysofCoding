//https://leetcode.com/problems/n-th-tribonacci-number/
import java.util.*;
public class TribonacciNumber {
    public int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        if(n == 0) return 0;
        if(n <= 2) return 1;
        int i = 2;
        while(i!=n){
            int nextc = a+b+c;
            a = b;
            b = c;
            c = nextc;
            i++;
        }
        return c;
    }
}
