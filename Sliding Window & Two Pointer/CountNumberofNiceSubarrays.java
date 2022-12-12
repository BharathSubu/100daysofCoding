
// https://leetcode.com/problems/count-number-of-nice-subarrays/

import java.util.*;

class CountNumberofNiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0) nums[i]=0;
            else nums[i]=1;
        }
        HashMap<Integer,Integer> visited = new HashMap<>();
        int presum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            if (presum == k)
                count++;
            int h = presum - k;
            if (visited.containsKey(h))
            {
                count += visited.get(h);
            }
            if(!visited.containsKey(presum))
            visited.put(presum, 1);
            else{
                visited.put(presum, visited.get(presum)+1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(numberOfSubarrays(arr, 2));
    }

}