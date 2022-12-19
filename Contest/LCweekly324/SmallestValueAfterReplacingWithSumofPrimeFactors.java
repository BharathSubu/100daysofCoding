

// https://leetcode.com/contest/weekly-contest-324/problems/smallest-value-after-replacing-with-sum-of-prime-factors/

import java.util.*;

import javax.lang.model.element.ModuleElement.Directive;
import javax.swing.text.html.BlockView;

class SmallestValueAfterReplacingWithSumofPrimeFactors {
    boolean prime[] ;
    public int smallestValue(int n) {
        prime = new boolean[n+1];
        sieveOfEratosthenes(n);
        while(!prime[n]){
            int prev = n;
            n = primeFactors(n);
            if(n== prev) return n;
        }
        return n;
    }
    public int primeFactors(int n)
    {
        int res = 0;
        while (n % 2 == 0) {
            res+=2;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                res+=i;
                n /= i;
            }
        }
        if (n > 2)
            res+=n;
        return res;
    }
    void sieveOfEratosthenes(int n)
    {
        for (int i = 0; i <= n; i++)
            prime[i] = true;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        SmallestValueAfterReplacingWithSumofPrimeFactors sol = new SmallestValueAfterReplacingWithSumofPrimeFactors();
        System.out.println(sol.smallestValue(12));
        
    }
}
