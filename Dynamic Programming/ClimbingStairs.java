//https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-ways-to-reach-the-nth-stair-1587115620
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=1) return n;
        long mod = (long) Math.pow(10,9)+7;
        long prev = 1 , prev2= 0;
        for(int i=2;i<=n+1;i++){
            long curri = prev2 + prev;
            prev2 = prev;
            prev = curri;
            prev%=mod;
            prev2%=mod;
        }
        return (int)prev;
    }
}
