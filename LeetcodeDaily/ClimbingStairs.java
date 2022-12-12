//https://leetcode.com/problems/climbing-stairs/


public class ClimbingStairs {

    public int climbStairs(int n) {
        int res = 0;
        int noOf2 = n/2;
        for (int i = 0; i <= noOf2; i++) {
            res+=calNcR(n-i,i);
        }
        return res;
    }

    public int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }

    int calNcR(int n , int r){
        int p = 1 , k =1;
        if(n-r < r) r = n -r;
        if(r!=0){
            while(r!=0){
                p*=n;
                k*=r;
                long m = gcd(p,k);
                p/=m;
                k/=m;
                n--;
                r--;
            }
        }
        else p = 1;
        return p;
    }

}
