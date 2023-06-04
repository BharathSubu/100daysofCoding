//https://practice.geeksforgeeks.org/problem-of-the-day
public class MaximumIdenticalBowls {
    public static int getMaximum(int n, int[] nums) {

        long sum=0;
        for(int i:nums){
            sum+=i;
        }
        while(n>1){
            if(sum%n==0){
                return n;
            }
            n--;
        }
        return 1;
    }
}
