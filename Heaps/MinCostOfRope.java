// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-cost-of-ropes

import java.util.*;

class MinCostOfRope
{
    long minCost(long arr[], int n) 
    {
        if(n==1) return arr[0];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long integer : arr) {
            pq.add(integer);
        }
        long res = 0;
        while(pq.size()!=1){
            long frst = pq.poll() , scnd = pq.poll();
            long sum = frst+scnd;
            res+=sum;
            pq.add(sum);
        }
        return res;
        
    }
    public static void main(String[] args) {
        MinCostOfRope sol = new MinCostOfRope();
        long[] arr = {4,3,2,6};
        System.out.println(sol.minCost(arr, arr.length));
    }
}