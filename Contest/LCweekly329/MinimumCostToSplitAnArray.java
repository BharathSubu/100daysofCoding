//https://leetcode.com/contest/weekly-contest-329/problems/minimum-cost-to-split-an-array/

import java.util.*;

public class MinimumCostToSplitAnArray {
    public int minCost(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean has2 = false;
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
//            System.out.println(map);
            if(!has2 && map.getOrDefault(nums[i],0) <= k)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            else{
                sum+=k;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(entry.getValue() != 1)
                    sum+= entry.getValue();
                }
                has2 = false;
                map = new HashMap<>();
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//                System.out.println(sum);
            }
            if(map.getOrDefault(nums[i],0) == 2) has2 = true;
        }
        if(!map.isEmpty()){
            sum+=k;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() != 1)
                    sum+= entry.getValue();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimumCostToSplitAnArray sol = new MinimumCostToSplitAnArray();
        int arr[] ={1,2,1,2,1};
        System.out.println(sol.minCost(arr,5));
    }
}
